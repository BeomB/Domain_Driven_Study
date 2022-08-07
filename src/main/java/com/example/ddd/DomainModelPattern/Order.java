package com.example.ddd.DomainModelPattern;

import org.aspectj.weaver.ast.Or;

import java.util.List;

public class Order {

    private String orderNumber;
    private List<OrderLine> orderLines;
    private Money totalAmounts;
    private OrderState state;
    private ShippingInfo shippingInfo;

    public Order(List<OrderLine> orderLines,ShippingInfo shippingInfo)
    {
        setOrderLines(orderLines);
        setShippingInfo(shippingInfo);
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null) return false;
        if (obj.getClass() != Order.class) return false;
        Order other = (Order) obj;
        if (this.orderNumber == null) return false;
        return this.orderNumber.equals(other.orderNumber);
    }

   @Override
   public int hashCode()
   {
       final int prime = 31;
       int result =1;
       result = prime * result  + ((orderNumber==null)?0 : orderNumber.hashCode());
       return result;
   }

    private void setShippingInfo(ShippingInfo shippingInfo) {
        if (shippingInfo==null){
            throw new IllegalStateException("배송지 목록 필요합니다.");
        }
        this.shippingInfo= shippingInfo;
    }

    private void setOrderLines(List<OrderLine> orderLines) {
        verifyAtLeastOneOrMoreOrderLines(orderLines);
        this.orderLines = orderLines;
        calculateTotalAmounts();
    }

    private void calculateTotalAmounts() {
        int sum = orderLines.stream().mapToInt(x->x.getAmounts()).sum();
        this.totalAmounts = new Money(sum);
    }

    private void verifyAtLeastOneOrMoreOrderLines(List<OrderLine> orderLines) {
        if(orderLines == null || orderLines.isEmpty())
        {
            throw new IllegalStateException("한 개 이상의 주문이 없습니다.");
        }
    }

    public void changeShippingInfo(ShippingInfo newShippingInfo)
    {
      verifyNotYetShipped();
      setShippingInfo(newShippingInfo);
    }

    private void verifyNotYetShipped() {
        if (state != OrderState.PAYMENT_WAITING && state != OrderState.PREPARING)
            throw new IllegalStateException("이미 배송했습니다.");
    }

    private boolean isShippingChangeable()              ///상품 준비 중, 주문 대기중일때 TRUE
    {
        return state == OrderState.PAYMENT_WAITING ||
                state == OrderState.PREPARING;
    }

    public void changeShipped() {}
    public void cancel(){}
    public void completePayment(){}



}




//
//public class ShippingInfo{
//
//    private String receiverName;            //받는 사람
//    private String receiverPhoneNumber;
//
//    private String shippingAddress1;        //주소
//    private String shippingAddress2;
//    private String shippingAddress3;
//    private String zipcode;
//}
//
//public class Receiver
//{
//    private String receiverName;            //받는 사람
//    private String receiverPhoneNumber;
//}
//
////public class Address
////{
////    private String address1;        //주소
////    private String address2;
//    private String address3;
//    private String zipcode;
//}





