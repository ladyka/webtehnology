package org.vurtatoo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SQLREQUESTS {
	
	private static LocalDate date = LocalDate.now();
	private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern( "yyyy-MM-dd ");

	/**
	 * Вывести полную информацию о заданном заказе.
	 * 
	 * @param order
	 *            id
	 * @return
	 */
	public static String getOrderInfoSQL(int order) {
		return  "select  "
				+  "shipment.NAME,  "
				+  "shipment.description,  "
				+  "shipment.price,  "
				+  "shipmentorder_has_shipment.count  "
				+  "from shipmentorder_has_shipment  "
				+  "join shipment on shipment.id = shipmentorder_has_shipment.SHIPMENT_id  "
				+  "where SHIPMENTORDER_id =  " + order;
	}

	/**
	 * Вывести номера заказов, сумма которых не превосходит заданную, и
	 * количество различных товаров равно заданному.
	 * 
	 * @param price
	 * @param shipments
	 * @return
	 */
	public static String getListOrdersSQL(int price, int shipments) {
		return  "select "
				+  "id "
				+  "from "
				+  "  shipmentorder "
				+  "where "
				+  "( "
				+ price
				+  " > (select  "
				+  "         sum(shipmentorder_has_shipment.count * shipment.price) summa "
				+  "     from " +  "         shipmentorder_has_shipment "
				+  "             join "
				+  "         shipment ON SHIPMENT_id = shipment.id "
				+  "     where "
				+  "         SHIPMENTORDER_id = shipmentorder.id)) "
				+  "     and ((select " +  "         count(*) " +  "     from "
				+  "         shipmentorder_has_shipment " +  "     where "
				+  "         SHIPMENTORDER_id = shipmentorder.id) =  "
				+ shipments +  ") ";
	}

	/**
	 * Вывести номера заказов, содержащих заданный товар.
	 * @param shipmentId
	 * @return Строка для получения списка интов, номеров заказа
	 */
	public static String getOrdersNumberSQL(int shipmentId) {
		return  "select  SHIPMENTORDER_id from shipmentorder_has_shipment  "
				+  "where shipmentorder_has_shipment.SHIPMENT_id =  " + shipmentId;
	}
	
	
	// Вывести номера заказов, не содержащих заданный товар и поступивших в
	// течение текущего дня.
	public static String getOrdersNotToday(int shipmentId) {
		return  "select  "
				+  "    SHIPMENTORDER_id "
				+  "from "
				+  "    shipmentorder_has_shipment "
				+  "        join "
				+  "    shipmentorder ON shipmentorder.id = SHIPMENTORDER_id "
				+  "where "
				+  "    (SHIPMENTORDER_id not in (select "
				+  "            SHIPMENTORDER_id "
				+  "        from "
				+  "            shipmentorder_has_shipment "
				+  "        where "
				+  "            shipmentorder_has_shipment.SHIPMENT_id =  " + shipmentId+  ")) "
				+  "        and (shipmentorder.timestamp > ' " + date.format(dateTimeFormatter)+ "') "
				+  "        and (shipmentorder.timestamp < ' " + date.plusDays(1).format(dateTimeFormatter)+  "') ";	}
	
	// Сформировать новый заказ, состоящий из товаров, заказанных в текущий
	// день.
	public static String getShipmentsOrderToday() {
		return  "SELECT  "  
				+  " SHIPMENT_id "  
				+  "			    FROM "  
				+  "			        shipmentorder_has_shipment "  
				+  "			            join "  
				+  "			        shipmentorder ON (shipmentorder.timestamp > ' " + date.format(dateTimeFormatter)+ "') "  
				+  "			            and (shipmentorder.timestamp < ' " + date.plusDays(1).format(dateTimeFormatter)+  "') "  
				+  "			            and shipmentorder.id = shipmentorder_has_shipment.SHIPMENTORDER_id "  
				+  "			    group by SHIPMENT_id ";
	}
	
	// Удалить заказ c товарами в нем
	public static String delOrdersSQL(int orderId) {
		return  "START TRANSACTION; "
				+  "SET @id_to_delete = 2; "
				+  "DELETE FROM shipmentorder_has_shipment "
				+  "    USING shipmentorder_has_shipment, shipmentorder "
				+  "    WHERE `shipmentorder`.`id` = `shipmentorder_has_shipment`.`SHIPMENTORDER_id` "
				+  "          AND shipmentorder.id = @id_to_delete; "
				+  "DELETE FROM shipmentorder "
				+  "    USING shipmentorder "
				+  "    WHERE shipmentorder.id = @id_to_delete; "
				+  "COMMIT ";
	}
	
	// Получить все заказы, в которых присутствует заданное количество заданного
	// товара.
	public static String getOrdersSQL(int shipmentId, int count) {
		return  "SELECT SHIPMENTORDER_id FROM work2v6.shipmentorder_has_shipment where SHIPMENT_id =  " + shipmentId +  " and count =  " + count;
	}

}
