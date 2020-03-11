package com.npf.knowledge.demo.java.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.text.DecimalFormat;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.java.excel
 * @ClassName: ReadExcel
 * @Author: ningpf
 * @Description: ${description}
 * @Date: 2020/3/1 11:22
 * @Version: 1.0
 */
public class ReadExcel {


    public void excel(){

    }


    public static void main(String[] args) {


        try{
            String path = "d://锅圈食汇需修改门店名称档案.xlsx";


            File excelFile = new File(path);

            Workbook workbook = new XSSFWorkbook(new FileInputStream(excelFile));

            for (int sheetNum = 0; sheetNum < workbook.getNumberOfSheets(); sheetNum++) {

                Sheet sheet = workbook.getSheetAt(sheetNum);

                int rowEnd = sheet.getPhysicalNumberOfRows();

                Cell cell = null;

                StringBuffer sql_bak = new StringBuffer();

                sql_bak.append("select * from dbi_shop where id in (");

                for (int rowNum = 1; rowNum < rowEnd; rowNum++) {
                    Row row = sheet.getRow(rowNum);

                    int cellNum = 0;
                    // 获取姓名
                    cell = row.getCell(cellNum++);

                    String shopId = convertCellValueToString(cell);

                    if(null == shopId){
                        sql_bak.append(")");
                        continue;
                    }

                    cell = row.getCell(cellNum++);

                    String oldName = convertCellValueToString(cell);

                    cell = row.getCell(cellNum++);

                    String shopState = convertCellValueToString(cell);

                    cell = row.getCell(cellNum++);

                    String shopOpenTime = convertCellValueToString(cell);

                    cell = row.getCell(cellNum++);

                    String newName = convertCellValueToString(cell);

                    cell = row.getCell(cellNum++);

                    String newFlag = convertCellValueToString(cell);

                    sql_bak.append(shopId).append(",");

                    StringBuffer sql = new StringBuffer();

                    sql.append("update dbi_shop set name = '");
                    sql.append(newName);
                    sql.append("' where id = ");
                    sql.append(shopId);
                    sql.append(";");
                    System.out.println(sql.toString());
                }
                System.out.println(sql_bak.toString());

            }


        }catch (Exception e){
            e.printStackTrace();
        }



    }


    /**
     * 将单元格内容转换为字符串
     * @param cell
     * @return
     */
    private static String convertCellValueToString(Cell cell) {
        if(cell==null){
            return null;
        }
        String returnValue = null;
        switch (cell.getCellType()) {
            case NUMERIC:   //数字
                Double doubleValue = cell.getNumericCellValue();

                // 格式化科学计数法，取一位整数
                DecimalFormat df = new DecimalFormat("0");
                returnValue = df.format(doubleValue);
                break;
            case STRING:    //字符串
                returnValue = cell.getStringCellValue();
                break;
            case BOOLEAN:   //布尔
                Boolean booleanValue = cell.getBooleanCellValue();
                returnValue = booleanValue.toString();
                break;
            case BLANK:     // 空值
                break;
            case FORMULA:   // 公式
                returnValue = cell.getCellFormula();
                break;
            case ERROR:     // 故障
                break;
            default:
                break;
        }
        return returnValue;
    }
}
