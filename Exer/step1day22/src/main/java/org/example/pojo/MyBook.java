package org.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.Atinterface.Book;
import org.junit.Test;

@Data
@Book(name = "三国", price = 20, anutor = "罗贯中")
public class MyBook {
    @Test
    @Book(name = "海底两万里",price = 100,anutor = "福迪")
    public void show(){
        System.out.println();
    }
}
