package com.liubingan.productandcomsumer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liubingang
 * @version 1.0
 * @date 2019 0:46
 */
public class ProductPool {

   private  List<Product> list;
   private  int maxSize = 0;
   public ProductPool(int maxSize) {
        this.list = new ArrayList<>();
        this.maxSize = maxSize;
   }

   public synchronized  void push(Product product){
       if (this.list.size() == maxSize){
           try{
               this.wait();
           } catch(Exception e){
               e.printStackTrace();
           }

       }
       this.list.add(product);
       this.notifyAll();
   }

   public synchronized Product pop(){
       if(this.list.size() == 0) {
            try{
                this.wait();
            }catch (Exception e) {
                e.printStackTrace();
            }
       }
       Product product  = this.list.remove(0);
       this.notifyAll();
       return product;

   }


}
