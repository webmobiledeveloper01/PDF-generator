package com.mysticplanets.pdf;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PDFSection {
	private String title;
    private List<PDFData> data;

    public PDFSection(String title, List<PDFData> data) {
        this.title = title;
        this.data = data;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<PDFData> getData() {
        return data;
    }

    public void setData(List<PDFData> data) {
        this.data = data;
    }
}