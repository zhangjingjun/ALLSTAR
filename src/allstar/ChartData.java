/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allstar;

/**
 *
 * @author jingjunzhang
 */
public class ChartData {
    private String text;
    private Number num;

    public ChartData(String text, Number num) {
        this.text = text;
        this.num = num;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Number getNum() {
        return num;
    }

    public void setNum(Number num) {
        this.num = num;
    }
    
    
}
