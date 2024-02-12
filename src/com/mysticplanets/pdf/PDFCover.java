package com.mysticplanets.pdf;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PDFCover {
	private String text1;
    private String text2;
    private String text3;
    
	public PDFCover(String string, String string2, String string3) {
		// TODO Auto-generated constructor stub
		setText1(string);
		setText2(string2);
		setText3(string3);
	}
	
	public String getText1() {
		// TODO Auto-generated method stub
		return text1;
	}
	public String getText2() {
		// TODO Auto-generated method stub
		return text2;
	}
	public String getText3() {
		// TODO Auto-generated method stub
		return text3;
	}
	
	public void setText1(String string) {
        this.text1 = string;
    }
	
	public void setText2(String string) {
        this.text2 = string;
    }
	
	public void setText3(String string) {
        this.text3 = string;
    }
    
}
