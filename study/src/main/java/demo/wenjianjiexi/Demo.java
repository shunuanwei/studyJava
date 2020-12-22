package demo.wenjianjiexi;

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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileLockInterruptionException;
import java.util.ArrayList;
import java.util.List;


public class Demo {
    public static void main(String[] args) throws IOException {
        String fileName = "E:\\jiexi\\test.xlsx";
//        List<String> tableHeaderList = getTableHeaderList(new File(fileName));
//        System.out.println(tableHeaderList);
//        List<String> tableHeaderList2 = getTableHeaderListHeaderList2(new File(fileName));
//        System.out.println(tableHeaderList2);
//        List<String> content = getTableHeaderList3(new File(fileName));
//        System.out.println(content);
//        List<List<String>> firstSheetDataListFor4 = getFirstSheetDataListFor4(new File(fileName));
//        System.out.println(firstSheetDataListFor4);
//        System.out.println("--"+getCommunityName(tableHeaderList2));
//        System.out.println("+++"+getAdvanceSaleNumber(tableHeaderList2));


//        System.out.println(content.indexOf(deleteSpace("户室号")));
//        int contentIndex = content.indexOf(deleteSpace("内容"));
//        int materialsIndex = content.indexOf(deleteSpace("装修材料"));
//        int brandNameIndex = content.indexOf(deleteSpace("品牌"));
//        int materialsTypeIndex = content.indexOf(deleteSpace("型号"));
//        int varietyIndex = content.indexOf(deleteSpace("品种"));
//        int specificationIndex = content.indexOf(deleteSpace("规格"));
//        int rankIndex = content.indexOf(deleteSpace("级别"));
//        int numberIndex = content.indexOf(deleteSpace("数量"));
//        int priceIndex = content.indexOf(deleteSpace("单价"));

        System.out.println(2 <= 3 ? 1 : null);
    }

    private static String getCommunityName(List<String> list){
        int count = 0;
        for (String s : list){
            if (count == 1){
                return s;
            }
            if (s != null && !"".equals(s)){
                count++;
            }
        }
        return null;
    }
    private static String getAdvanceSaleNumber(List<String> list){
        int count = 0;
        for (String s : list){
            if (count == 3){
                return s;
            }
            if (s != null && !"".equals(s)){
                count++;
            }
        }
        return null;
    }
    public static String deleteSpace(String textContent) {
        for (textContent = textContent.trim(); textContent.startsWith("　"); textContent = textContent.substring(1, textContent.length()).trim()) {
        }

        while (textContent.endsWith("　")) {
            textContent = textContent.substring(0, textContent.length() - 1).trim();
        }

        return textContent;
    }



    private static void checkFile(File file) throws IOException {
        if (!file.exists()) {
            throw new FileNotFoundException("文件不存在");
        } else {
            String fileName = file.getName();
            if (!fileName.endsWith("xls") && !fileName.endsWith("xlsx")) {
                throw new FileLockInterruptionException();
            }
        }
    }
    private static Workbook getWorkBook(File file) throws IOException {
        try {
            String fileName = file.getName();
            if (fileName.endsWith("xlsx")) {

                return new XSSFWorkbook(new FileInputStream(file));
            } else {
                return fileName.endsWith("xls") ? new HSSFWorkbook(new FileInputStream(file)) : null;
            }
        } catch (IOException var2) {
            System.out.println("excel 解析错误。");
            return null;
        }
    }
    private static List<String> getTableHeaderList(File file) throws IOException {
        checkFile(file);
        Workbook wb = getWorkBook(file);
        List<String> headList = new ArrayList();
        Sheet sheet = wb.getSheetAt(0);
        Row row = sheet.getRow(sheet.getFirstRowNum());
        if (row == null) {
            return headList;
        } else {
            for (int j = row.getFirstCellNum(); j < row.getLastCellNum(); ++j) {
                Cell cell = row.getCell(j);
                if (cell == null) {
                    return headList;
                }
                headList.add(getCellStringVal(cell));
            }
            return headList;
        }
    }
    private static List<String> getTableHeaderList2(File file) throws IOException {
        checkFile(file);
        Workbook wb = getWorkBook(file);
        List<String> headList = new ArrayList();
        Sheet sheet = wb.getSheetAt(0);
        Row row = sheet.getRow(sheet.getFirstRowNum() + 1);
        if (row == null) {
            return headList;
        } else {
            for (int j = row.getFirstCellNum(); j < row.getLastCellNum(); ++j) {
                Cell cell = row.getCell(j);
                headList.add(getCellStringVal(cell));
            }

            return headList;
        }
    }

    private static List<String> getTableHeaderList3(File file) throws IOException {
        checkFile(file);
        Workbook wb = getWorkBook(file);
        List<String> headList = new ArrayList();
        Sheet sheet = wb.getSheetAt(0);
        Row row = sheet.getRow(sheet.getFirstRowNum() + 2);
        if (row == null) {
            return headList;
        } else {
            for (int j = row.getFirstCellNum(); j < row.getLastCellNum(); ++j) {
                Cell cell = row.getCell(j);
                if (cell == null) {
                    return headList;
                }

                headList.add(getCellStringVal(cell));
            }

            return headList;
        }
    }

    private static List<List<String>> getFirstSheetDataListFor4(File file) throws IOException {
        checkFile(file);
        Workbook wb = getWorkBook(file);
        List<List<String>> rowList = new ArrayList();
        Sheet sheet = wb.getSheetAt(0);

        for (int i = sheet.getFirstRowNum() + 3; i <= sheet.getLastRowNum(); ++i) {
            Row row = sheet.getRow(i);
            if (row != null) {
                List<String> cellList = new ArrayList();

                for (int j = row.getFirstCellNum(); j < row.getLastCellNum(); ++j) {
                    Cell cell = row.getCell(j);
                    cellList.add(getCellStringVal(cell));
                }

                rowList.add(cellList);
            }
        }

        return rowList;
    }

    private static String getCellStringVal(Cell cell) {
        if (cell == null) {
            return "";
        }
        CellType cellType = cell.getCellTypeEnum();
        switch (cellType) {
            case NUMERIC:
                DataFormatter dataFormatter = new DataFormatter();
                return dataFormatter.formatCellValue(cell);
//                return String.valueOf(cell.getNumericCellValue());
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
            case BLANK:
                return "";
            case ERROR:
                return String.valueOf(cell.getErrorCellValue());
            default:
                return "";
        }
    }

}