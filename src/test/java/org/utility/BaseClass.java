package org.utility;

	import java.awt.AWTException;
	import java.awt.Robot;
	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.io.IOException;

	import java.text.SimpleDateFormat;
	import java.util.Date;


	import org.apache.commons.io.FileUtils;
	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.DateUtil;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class BaseClass {
		public static WebDriver driver;
		public static TakesScreenshot ts;
		public static Actions act;
		public static JavascriptExecutor js;
		public static Robot r;
	public static void launchTheBrowser() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
	}
	public static void windowMaximize() {
		driver.manage().window().maximize();
	}
	public static void launchTheUrl(String url){
		driver.get(url);
	}
	public static void passingText(WebElement ref,String name) {
		ref.sendKeys(name);
	}
	public static void clickTheLogin(WebElement ref) {
		ref.click();
	}
	public static void gettingTheText(WebElement ref) {
		String text = ref.getText();
		System.out.println(text);
	}
	public static void closeTheBrowser() {
		driver.close();
	}
	public static void quitTheBrowser() {
		driver.quit();
	}

	public static void screenShot(String path) throws IOException {
		ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination =new File("C:\\Users\\gowth\\eclipse-workspace\\Selenium\\Screenshot\\fb.img");
		FileUtils.copyDirectory(source, destination);
	}
	public static void actionsClass() {
		act = new Actions(driver);
		//a.moveToElement();
		//a.doubleClick();
		//a.contextClick();
	}

	public static void moveToElement(WebElement target) {
		act=new Actions(driver);
		act.moveToElement(target).perform();

	}
	public static void contextClick(WebElement target) {
		act=new Actions(driver);
		act.contextClick(target).perform();
	}
	public static void doubleClick(WebElement target) {
		act=new Actions(driver);
		act.doubleClick(target).perform();
	}
		
	public static void dragAndDrop(WebElement source, WebElement target) {
		act=new Actions(driver);
		act.dragAndDrop(source, target).perform();
	}

	public static void javaScript() {
		js=(JavascriptExecutor)driver;
	}
	public static void javascriptsendKeys(WebElement ele, String attributeName, String sendValue) {
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('"+ attributeName +"','"+ sendValue +"')",ele);
	}
	public static void javascriptgetText(WebElement ele, String attributeName) {
		js=(JavascriptExecutor)driver;
		js.executeScript("return arguments[0].getAttribute('"+ attributeName +"')", ele);
	}
	public static void topView(WebElement ele) {
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)",ele);
	}
	public static void bottomView(WebElement ele) {
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(false)",ele);
	}

	public static void keyPress() throws AWTException {
	Robot r = new Robot();
	r.keyPress(0);
	}
	public static void keyRelease() throws AWTException {
	r = new Robot();
	r.keyRelease(0);
	}

	public static void createExcelSheet(String newsheetname, int newcell, int newrow, String setdata) throws IOException {
		
		File f = new File("C:\\Users\\gowth\\eclipse-workspace\\MavenProject\\Excel\\excel.xlsx");
		//to read the xlsx sheet
		FileInputStream fis = new FileInputStream(f);
		
		//to write the xlsx sheet
			FileOutputStream fos = new FileOutputStream(f);
		
		
		//create the workbook
		Workbook w = new XSSFWorkbook(fis);
		
		//create sheet
		Sheet cs= w.createSheet(newsheetname);
		
		//create row
		Row cr = cs.createRow(newrow);
		
		//create cell
		Cell cc = cr.createCell(newcell);
		
		//set the value in the cell
		cc.setCellValue(setdata);
		
		w.write(fos);

	}

	public static String getExcelSheet(String getsheetname, int getrow, int getcell) throws IOException {
		
		File f = new File("C:\\Users\\gowth\\eclipse-workspace\\MavenProject\\Excel\\excel.xlsx");
		//to read the xlsx sheet
		FileInputStream fis = new FileInputStream(f);
		
		//to write the xlsx sheet
			//FileOutputStream fos = new FileOutputStream(f);
		
		
		//create the workbook
		Workbook w = new XSSFWorkbook(fis);

		//to get the sheet from the workbook
		Sheet getparticularsheet = w.getSheet(getsheetname);
		
		//to iterate all the rows
		//for (int i = 0; i < getparticularsheet.getPhysicalNumberOfRows(); i++) {
			
			Row fromrow = getparticularsheet.getRow(getrow);
			
			//to iterate all the cells
			//for (int j = 0; j < fromrow.getPhysicalNumberOfCells(); j++) {
				
				Cell cell = fromrow.getCell(getcell);
				
				int cellType = cell.getCellType();
				
				//celltype equal to one means its string type
				//other than 1 it will be numeric cell or date cell type
	            //to get string cell data type
				
				
				String value = "";
				
				if(cellType==1) {
					
					 value = cell.getStringCellValue();
					
					//System.out.println(cellValue);
					
				}
				//to get date cell type
				else if (DateUtil.isCellDateFormatted(cell)) {
					
					Date dateCellValue = cell.getDateCellValue();
				
					SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

					value = sdf.format(dateCellValue);
					
					//System.out.println(dateformat);
				}
				// to get numeric cell data type
				else {
					double numericCellValue = cell.getNumericCellValue();
			
					long l = (long)numericCellValue;
					
					value = String.valueOf(l);
					
					//System.out.println(numericvalue);
					
				}
		        return value;		
	
				//System.out.println(cell);
			}		
		//to get the row from the sheet
		//Row getparticularrow = getparticularsheet.getRow(1);
		
		//to get the cell from the row
		//Cell getparticulardata = getparticularrow.getCell(1);
		
		//System.out.println(getparticulardata);
		
		
	}

		
		
		
		
		
		
		
		
		
		
		
		
		
		























	
	

