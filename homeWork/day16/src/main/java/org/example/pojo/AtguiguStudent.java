package org.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.val;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AtguiguStudent implements Serializable, Comparable {
    private static String school;
    private String className;

    @Override
    public int compareTo(Object o) {
        String className = (String) o;
        val charArray1 = className.toCharArray();
        val charArray2 = this.className.toCharArray();
        return charArray1.length - charArray2.length;
    }
}
