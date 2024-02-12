package com.mysticplanets.pdf;

import com.itextpdf.text.Image;
import com.itextpdf.text.html.WebColors;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.*;

//import com.itextpdf.kernel.colors.DeviceRgb;
//import com.itextpdf.layout.element.Text;
//import com.itextpdf.layout.property.VerticalAlignment;
import com.itextpdf.text.*;
import com.itextpdf.text.Font;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PDFGenerator extends JFrame {
	private JTextField text1Field;
    private JTextField text2Field;
    private JTextField text3Field;
    /*private JTextArea sectionTitleField;
    private JTextArea sectionDescriptionField;
    private JTextArea dataTitleField;
    private JTextArea dataDescriptionField;
    private JTextArea colorField;*/
    private JButton generateButton;
    private BufferedImage backgroundImage;

    public PDFGenerator() {
        setTitle("PDF Generator");
        setSize(600, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);

        // Set background image
        try {
        	String imagePath = "./background.png";
            File imageFile = new File(imagePath);
            backgroundImage = ImageIO.read(imageFile);
            //Image backgroundImage = ImageIO.read(imageFile);
            //setContentPane(new JLabel(new ImageIcon(backgroundImage)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        JPanel contentPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);
            }
        };
        contentPanel.setLayout(null);
        contentPanel.setBounds(0, 0, getWidth(), getHeight()-40);
        add(contentPanel);

        /*JLabel titleLabel = new JLabel("Title:");
        titleLabel.setBounds(10, 10, 80, 25);
        contentPanel.add(titleLabel);*/

        text1Field = new JTextField();
        text1Field.setBounds(30, 235, 260, 25);
        contentPanel.add(text1Field);

        /*JLabel subtitleLabel = new JLabel("Subtitle:");
        subtitleLabel.setBounds(10, 40, 80, 25);
        contentPanel.add(subtitleLabel);*/

        text2Field = new JTextField();
        text2Field.setBounds(30, 520, 260, 25);
        contentPanel.add(text2Field);

        /*JLabel authorLabel = new JLabel("Author:");
        authorLabel.setBounds(10, 70, 80, 25);
        contentPanel.add(authorLabel);*/

        text3Field = new JTextField();
        text3Field.setBounds(30, 550, 260, 25);
        contentPanel.add(text3Field);

        /*JLabel sectionTitleLabel = new JLabel("Section Title:");
        sectionTitleLabel.setBounds(10, 100, 80, 25);
        contentPanel.add(sectionTitleLabel);

        sectionTitleField = new JTextArea();
        sectionTitleField.setBounds(100, 100, 280, 60);
        contentPanel.add(sectionTitleField);

        JLabel sectionDescriptionLabel = new JLabel("Section Description:");
        sectionDescriptionLabel.setBounds(10, 170, 120, 25);
        contentPanel.add(sectionDescriptionLabel);

        sectionDescriptionField = new JTextArea();
        sectionDescriptionField.setBounds(130, 170, 250, 60);
        contentPanel.add(sectionDescriptionField);

        JLabel dataTitleLabel = new JLabel("Data Title:");
        dataTitleLabel.setBounds(10, 240, 80, 25);
        contentPanel.add(dataTitleLabel);

        dataTitleField = new JTextArea();
        dataTitleField.setBounds(100, 240, 280, 60);
        contentPanel.add(dataTitleField);

        JLabel dataDescriptionLabel = new JLabel("Data Description:");
        dataDescriptionLabel.setBounds(10, 310, 120, 25);
        contentPanel.add(dataDescriptionLabel);

        dataDescriptionField = new JTextArea();
        dataDescriptionField.setBounds(130, 310, 250, 60);
        contentPanel.add(dataDescriptionField);

        JLabel colorLabel = new JLabel("Color:");
        colorLabel.setBounds(10, 380, 80, 25);
        contentPanel.add(colorLabel);

        colorField = new JTextArea();
        colorField.setBounds(100, 380, 280, 60);
        contentPanel.add(colorField);*/

        generateButton = new JButton("Generate PDF");
        generateButton.setBounds(225, 650, 120, 25);
        contentPanel.add(generateButton);

        generateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generatePDF();
            }
        });
    }
    
    /*@Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);
    }*/

    public void generatePDF() {
        // Get input values from the GUI
        String text1 = text1Field.getText();
        String text2 = text2Field.getText();
        String text3 = text3Field.getText();
        //String sectionTitle = sectionTitleField.getText();
        //String sectionDescription = sectionDescriptionField.getText();
        //String dataTitle = dataTitleField.getText();
        //String dataDescription = dataDescriptionField.getText();
        //String color = colorField.getText();
        
        //PDFCover pdfCover = new PDFCover("text1", "text2", "text3");
        PDFCover pdfCover = new PDFCover(text1, text2, text3);
                
        PDFData pdfData1 = new PDFData();
        pdfData1.setTitle("title1");
        pdfData1.setTitleColor("#2b347a");
        pdfData1.setDesc("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's " +
                "standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled " +
                "it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, " +
                "remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum " +
                "passages, " +
                "and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        
        PDFData pdfData2 = new PDFData();
        pdfData2.setTitle("title2");
        pdfData2.setTitleColor("#e05e0d");
        pdfData2.setDesc("There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, " +
                "by injected humour, or randomised words which don't look even slightly believable. " +
                "If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. " +
                "All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, " +
                "making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, " +
                "combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable. " +
                "The generated Lorem Ipsum is therefore always free from repetition, " +
                "injected humour, or non-characteristic words etc.");
        
        PDFData pdfData3 = new PDFData();
        pdfData3.setTitle("title3");
        pdfData3.setTitleColor("#2b347a");
        pdfData3.setDesc("Contrary to popular belief, Lorem Ipsum is not simply random text. " +
                "It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. " +
                "Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, " +
                "consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, " +
                "discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" " +
                "(The Extremes of Good and Evil) by Cicero, written in 45 BC. " +
                "This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, " +
                "Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32.");
        
        PDFData pdfData4 = new PDFData();
        pdfData4.setTitle("title4");
        pdfData4.setTitleColor("#e05e0d");
        pdfData4.setDesc("There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, " +
                "by injected humour, or randomised words which don't look even slightly believable. " +
                "If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. " +
                "All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, " +
                "making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, " +
                "combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable. " +
                "The generated Lorem Ipsum is therefore always free from repetition, " +
                "injected humour, or non-characteristic words etc.");
        
        
        PDFSection pdfSection1 = new PDFSection("Section1", Arrays.asList(pdfData1,pdfData2));
        PDFSection pdfSection2 = new PDFSection("Section2", Arrays.asList(pdfData3,pdfData4));

        generate(this, pdfCover, Arrays.asList(pdfSection1, pdfSection2));
        
        // Create PDF objects
        //PDFCover cover = new PDFCover(text1, text2, text3);
        //PDFData data = new PDFData(dataTitle, dataDescription, color);
        //PDFSection section = new PDFSection(sectionTitle, Collections.singletonList(data));     
    }
    
    public static void generate (PDFGenerator generator, PDFCover cover, List<PDFSection> sectionList) {
    	
    	// Generate PDF
        try {
            Document document = new Document(PageSize.A4);
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("output.pdf"));
            document.open();
            
            PdfContentByte canvas = writer.getDirectContent();
            
            
            String imagePath = "./background.png";
  
            Image backgroundImage1 = Image.getInstance(imagePath);
            backgroundImage1.scaleAbsolute(document.getPageSize().getWidth(), document.getPageSize().getHeight());
            
            backgroundImage1.setAbsolutePosition(0, 0);
            writer.getDirectContentUnder().addImage(backgroundImage1);
            
            // Set font and size
            BaseFont baseFont;
            try {
                baseFont = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
                
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
            
            PdfContentByte contentByte1 = writer.getDirectContent();
            contentByte1.setFontAndSize(baseFont, 12);
            
            contentByte1.setColorFill(new BaseColor(255, 255, 255));
           
            // Set position and alignment
            float x = 30; // X-coordinate of the text position
            float y = 800-235; // Y-coordinate of the text position
            int alignment1 = Element.ALIGN_LEFT;

            // Output the text
            contentByte1.beginText();
            contentByte1.showTextAligned(alignment1, cover.getText1(), x, y, 0);
            x = 30;
            y = 800-520;
            contentByte1.showTextAligned(alignment1, cover.getText2(), x, y, 0);
            x = 30;
            y = 800-550;
            contentByte1.showTextAligned(alignment1, cover.getText3(), x, y, 0);
            
            contentByte1.endText();       
            
           
            String imagePath1 = "./background1.png";
            
            Image backgroundImage2 = Image.getInstance(imagePath1);
            backgroundImage2.scaleAbsolute(document.getPageSize().getWidth(), document.getPageSize().getHeight());
            
            backgroundImage2.setAbsolutePosition(0, 0);
            //writer.getDirectContentUnder().addImage(backgroundImage2);
            
            
           
            
            
            // Add section information
            for (PDFSection section : sectionList) {
            	document.newPage();
            	writer.getDirectContentUnder().addImage(backgroundImage2);
            	
            	BaseColor sectionFontColor = WebColors.getRGBColor("#ffffff");
            	Font sectionTitleFont = new Font(Font.FontFamily.HELVETICA , 24, Font.BOLD, sectionFontColor);
                Paragraph paragraph = new Paragraph(section.getTitle(), sectionTitleFont);
                
            	//Paragraph paragraph = new Paragraph(section.getTitle());
            	paragraph.setAlignment(Element.ALIGN_CENTER);
            	document.add(paragraph);           	

             // Add data information
                for (PDFData data1 : section.getData()) {
                    //document.add(new Paragraph("Data Title: " + data1.getTitle()));
                	document.add(new Paragraph(""));
                	
                	BaseColor fontColor = WebColors.getRGBColor(data1.getTitleColor());
                	Font titleFont = new Font(Font.FontFamily.HELVETICA , 18, Font.BOLD, fontColor);
                    Paragraph titleParagraph = new Paragraph(data1.getTitle(), titleFont);
                	
                    titleParagraph.setAlignment(Element.ALIGN_CENTER);
                    document.add(titleParagraph);
                    
                 // Set color
                    float red = 186 / 255f;
                    float green = 219 / 255f;
                    float blue = 243 / 255f;
                    float alpha = 255 / 255f;
                    BaseColor descColor = new BaseColor(red, green, blue, alpha);
                    
                    Font descFont = new Font(Font.FontFamily.HELVETICA , 12, Font.NORMAL , descColor);
                    Paragraph descParagraph = new Paragraph(data1.getDesc(), descFont);
                    document.add(descParagraph);
                    
                    //document.add(new Paragraph("Data Description: " + data1.getDesc()));
                }
                
                
                PdfContentByte contentByte2 = writer.getDirectContent();
                contentByte2.setFontAndSize(baseFont, 12);
                
                contentByte2.setColorFill(new BaseColor(255, 255, 255));
                
                // Set position and alignment
                x = 215; // X-coordinate of the text position
                y = 20; // Y-coordinate of the text position
                int alignment2 = Element.ALIGN_LEFT;
                // Output the text
                contentByte2.beginText();
                contentByte2.showTextAligned(alignment2, "www.mystic-planets.com", x, y, 0);
                contentByte2.endText(); 
                
            }
            
            document.close();
            writer.close();
            JOptionPane.showMessageDialog(generator, "PDF generated successfully!");
        } catch (DocumentException | IOException  ex) {
            JOptionPane.showMessageDialog(generator, "Error generating PDF: " + ex.getMessage());
        }
        
        System.out.println("generated...");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
        	@Override
            public void run() {
                new PDFGenerator().setVisible(true);
            }
        });
    }
}
