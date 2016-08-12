package continuum_automation.cucumber;




import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.runners.model.TestClass;
import org.testng.Reporter;



public class Utilities {
	
	public static String  getMavenProperties(String key){
	
	 Properties mavenProps = new Properties();
	 InputStream inStream = TestClass.class.getResourceAsStream("/maven.properties");
	 try {
		mavenProps.load(inStream);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	return mavenProps.getProperty(key);
	}
	
//	public List<cellValue> readBooksFromExcelFile(String excelFilePath) throws IOException {
//	    List<Book> listBooks = new ArrayList<>();
//	    FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
//	 
//	    Workbook workbook = new XSSFWorkbook(inputStream);
//	    Sheet firstSheet = workbook.getSheetAt(0);
//	    Iterator<Row> iterator = firstSheet.iterator();
//	 
//	    while (iterator.hasNext()) {
//	        Row nextRow = iterator.next();
//	        Iterator<Cell> cellIterator = nextRow.cellIterator();
//	        Book aBook = new Book();
//	 
//	        while (cellIterator.hasNext()) {
//	            Cell nextCell = cellIterator.next();
//	            int columnIndex = nextCell.getColumnIndex();
//	 
//	            switch (columnIndex) {
//	            case 1:
//	                aBook.setTitle((String) getCellValue(nextCell));
//	                break;
//	            case 2:
//	                aBook.setAuthor((String) getCellValue(nextCell));
//	                break;
//	            case 3:
//	                aBook.setPrice((double) getCellValue(nextCell));
//	                break;
//	            }
//	 
//	 
//	        }
//	        listBooks.add(aBook); 
//	    }
//	 
//	    workbook.close();
//	    inputStream.close();
//	 
//	    return listBooks;
//	}
//	private Object getCellValue(Cell cell) {
//	    switch (cell.getCellType()) {
//	    case Cell.CELL_TYPE_STRING:
//	        return cell.getStringCellValue();
//	 
//	    case Cell.CELL_TYPE_BOOLEAN:
//	        return cell.getBooleanCellValue();
//	 
//	    case Cell.CELL_TYPE_NUMERIC:
//	        return cell.getNumericCellValue();
//	    }
//	 
//	    return null;
//	}
	
	
}

