/*
 * COPYRIGHT. ShenZhen JiMi Technology Co., Ltd. 2019.
 * ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system, or transmitted,
 * on any form or by any means, electronic, mechanical, photocopying, recording,
 * or otherwise, without the prior written permission of ShenZhen JiMi Network Technology Co., Ltd.
 *
 * Amendment History:
 *
 * Date                   By              Description
 * -------------------    -----------     -------------------------------------------
 * 2019/3/28    Tanlianwang         Create the class
 * http://www.jimilab.com/
 */


package com.jimi.excel;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author Tanlianwang
 * @version 1.0
 * @date 2019/3/28 18:14
 */
public class ReadExcel {
    public static void main(String[] args) throws  Exception{
        //创建输入流
        FileInputStream fis = new FileInputStream(new File("E:\\root\\sheet\\hello.xlsx"));
        //由输入流得到工作簿
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        //得到工作表
        XSSFSheet sheet = workbook.getSheet("hello");
        //得到行,0表示第一行
        XSSFRow row = sheet.getRow(0);
        //创建单元格行号由row确定,列号作为参数传递给createCell;第一列从0开始计算
        XSSFCell cell = row.getCell(2);
        //给单元格赋值
        String cellValue = cell.getStringCellValue();
        System.out.println("C1的值是"+cellValue);
        int a[][] = new int[10][30];
        for(int i=0;i<a.length;i++)
        {
            System.out.println(i);
        }
        workbook.close();
        fis.close();
    }
}
