package org.vurtatoo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ShipmentOrderView implements Serializable {

	private static final long serialVersionUID = 21L;
	
    private int shipmentOrderId;
	private LocalDateTime timestamp;
    private String shipmentName;
    private String shipmentDescription;
    private int shipmentPrice;
    private int count;
    
	public ShipmentOrderView(int shipmentorder_id,
			String shipmentorder_timestamp, String shipment_NAME,
			String shipment_description, int shipment_price,
			int shipmentorder_has_shipment_count) {
		super();
		this.shipmentOrderId = shipmentorder_id;
		this.timestamp = LocalDateTime.parse(shipmentorder_timestamp.substring(0, 19), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		this.shipmentName = shipment_NAME;
		this.shipmentDescription = shipment_description;
		this.shipmentPrice = shipment_price;
		this.count = shipmentorder_has_shipment_count;
	}

	public int getShipmentOrderId() {
		return shipmentOrderId;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public String getShipmentName() {
		return shipmentName;
	}

	public String getShipmentDescription() {
		return shipmentDescription;
	}

	public int getShipmentPrice() {
		return shipmentPrice;
	}

	public int getCount() {
		return count;
	}

	public void setShipmentOrderId(int shipmentOrderId) {
		this.shipmentOrderId = shipmentOrderId;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public void setShipmentName(String shipmentName) {
		this.shipmentName = shipmentName;
	}

	public void setShipmentDescription(String shipmentDescription) {
		this.shipmentDescription = shipmentDescription;
	}

	public void setShipmentPrice(int shipmentPrice) {
		this.shipmentPrice = shipmentPrice;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	
	

}
