package viewmodel;

public class OrderItem {
    public String getProductId() {
        return ProductId;
    }

    public void setProductId(String productId) {
        ProductId = productId;
    }

    public int getQty() {
        return Qty;
    }

    public void setQty(int qty) {
        Qty = qty;
    }

    public String getDeliveryAddress() {
        return DeliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        DeliveryAddress = deliveryAddress;
    }

    public String ProductId;
    public int Qty;
    public String DeliveryAddress;

    public OrderItem(){}

    public OrderItem(String productId, int qty, String deliveryAddress) {
        this.ProductId = productId;
        this.Qty = qty;
        this.DeliveryAddress = deliveryAddress;
    }
}


