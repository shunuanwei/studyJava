package demo.jieixiwenjian;

import demo.exception.ApiException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 文件解析步骤 - (表格)
 * 1.判断文件是否存在
 */
public class Demo {

    /**
     * 确保文件存在且可读
     */
    private static Boolean checkFile(File file) {
        return (file != null && file.exists() && file.isFile() && file.canRead());
    }

    /**
     * 开始读取文件
     * 根据不同的后缀名采用不同的方式读取文件
     */
    private static Workbook getWorkBook(File file) {
        try {
            String fileName = file.getName();
            if (fileName.endsWith("xlsx")) {
                return new XSSFWorkbook(new FileInputStream(file));
            } else {
                return fileName.endsWith("xls") ? new HSSFWorkbook(new FileInputStream(file)) : null;
            }
        } catch (IOException e) {
            System.out.println("表格-打开读取错误");
            return null;
        }
    }

    /**
     * 对于获取的参数进行解析
     */
    private static String getCellStringVal(Cell cell) {
        if (cell == null) {
            return "";
        }
        CellType cellType = cell.getCellTypeEnum();
        switch (cellType) {
            case NUMERIC:
                DataFormatter dataFormatter = new DataFormatter();
                return dataFormatter.formatCellValue(cell);
            case STRING:
                return cell.getStringCellValue();
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                try {
                    return String.valueOf(cell.getStringCellValue());
                } catch (IllegalStateException var3) {
                    return String.valueOf(cell.getNumericCellValue());
                }
            case ERROR:
                return String.valueOf(cell.getErrorCellValue());
            default:
                return "";
        }
    }

    /**
     * 获取表格内容
     */
    private static List<List<String>> getContent(File file) {
        try {
            if (!checkFile(file)) {
                throw new ApiException("文件错误");
            }
            Workbook wb = getWorkBook(file);
            if (wb == null) {
                throw new ApiException("文件打开失败.解析内容失败");
            }
            List<List<String>> rowList = new ArrayList<>();
            Sheet sheet = wb.getSheetAt(0);
            for (int i = sheet.getFirstRowNum(); i <= sheet.getLastRowNum(); ++i) {
                Row row = sheet.getRow(i);
                if (row != null) {
                    List<String> cellList = new ArrayList<>();
                    for (int j = row.getFirstCellNum(); j < row.getLastCellNum(); ++j) {
                        Cell cell = row.getCell(j);
                        cellList.add(getCellStringVal(cell));
                    }
                    rowList.add(cellList);
                }
            }
            return rowList;
        } catch (Exception e) {
            throw new ApiException("解析内容失败");
        }
    }




    public static void main(String[] args) {
//        System.out.println(getContent(new File("E:/jiexi/test1.xlsx")));
        System.out.println(Demo.class.getClass().getClassLoader().getResourceAsStream("simsun.ttc"));
    }
}
