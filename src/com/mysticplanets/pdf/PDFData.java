package com.mysticplanets.pdf;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PDFData {
	private String title;
    private String desc;
    private String titleColor;
    
    public PDFData() {
		// TODO Auto-generated constructor stub
    	setTitle("");
    	setDesc("");
    	setTitleColor("");
	}
    
    public PDFData(String string, String string2, String string3) {
		// TODO Auto-generated constructor stub
    	setTitle(string);
    	setDesc(string2);
    	setTitleColor(string3);
	}
    
	public String getTitle() {
		// TODO Auto-generated method stub
		return title;
	}
	public String getDesc() {
		// TODO Auto-generated method stub
		return desc;
	}
	public String getTitleColor() {
		// TODO Auto-generated method stub
		return titleColor;
	}
	public void setTitle(String string) {
        this.title = string;
    }
	
	public void setDesc(String string) {
        this.desc = string;
    }
	
	public void setTitleColor(String string) {
        this.titleColor = string;
    }
}