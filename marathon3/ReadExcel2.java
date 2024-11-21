package marathon3;

import java.io.File;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel2 {

	public static String[][] readExcelData() throws InvalidFormatException, IOException {
		// TODO Auto-generated method stub
		
		//path of the Excelsheet
		File filepath = new File("./testData/EditLead.xlsx");
		
		
		//To open the workbook
        XSSFWorkbook  workbook = new XSSFWorkbook(filepath);
        
        //To access the worksheet
        
        XSSFSheet sheetName = workbook.getSheet("Sheet1");
        
        // To access the rowcount
             int rowCount = sheetName.getLastRowNum();
             System.out.println("Column Count -> "+rowCount);
     		
             XSSFRow firstRow = sheetName.getRow(0);
     		
     		//step6: Get the column count
     		int columnCount = firstRow.getLastCellNum();
     		System.out.println("Column Count -> "+columnCount);
     		
     		String[][] data = new String[rowCount][columnCount];
    		System.out.println("<----------------------All Test Data--------------------------->");
    		for (int i = 1; i <=rowCount; i++) {
    			for (int j = 0; j <columnCount; j++) {
    				String stringCellValue = sheetName.getRow(i).getCell(j).getStringCellValue();
    				System.out.println(stringCellValue);

    				data[i-1][j] = stringCellValue;

    			}
    		}
    		
    		workbook.close();
    		
    		return data;
    		
		
	}

}

	
