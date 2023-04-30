package excel.reader.excel;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class MyController {

	  @PostMapping("/upload")
	  public ResponseEntity<?> uploadExcel(@RequestParam("file") MultipartFile file) {
	    try {
	      InputStream inputStream = file.getInputStream();
	      Workbook workbook = new XSSFWorkbook(inputStream);
	      Sheet sheet = workbook.getSheetAt(0);
	      List<Map<String, Object>> rows = new ArrayList<>();
	      for (Row row : sheet) {
	        Map<String, Object> rowMap = new HashMap<>();
	        for (Cell cell : row) {
	          if (cell.getCellType() == CellType.NUMERIC) {
	        	  rowMap.put(String.valueOf(cell.getNumericCellValue()), "");
	          } else {
	        	  rowMap.put(cell.getStringCellValue(), "");
	          }
	        }
	        rows.add(rowMap);
	      }
	      return ResponseEntity.ok(rows);
	    } catch (IOException e) {
	      e.printStackTrace();
	      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error");
	    }
	  }
	  
	  @GetMapping("/")
	  public String helloWorld() {
	    return "Olá Mundo";
	  }

}
