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
import java.io.FileOutputStream;

/**
 * @author Tanlianwang
 * @version 1.0
 * @date 2019/3/28 18:07
 */
public class ExcelSplit {
    public static void main(String[] args)  throws Exception {
        //创建工作簿
        XSSFWorkbook workbook = new XSSFWorkbook();
        //新建工作表
        XSSFSheet sheet = workbook.createSheet("hello");
        //创建行,0表示第一行
        XSSFRow row = sheet.createRow(0);
        //创建单元格行号由row确定,列号作为参数传递给createCell;第一列从0开始计算
        XSSFCell cell = row.createCell(2);
        //给单元格赋值
        cell.setCellValue("hello sheet");
        //创建输出流
        FileOutputStream fos = new FileOutputStream(new File("F:\\hello.xlsx"));
        workbook.write(fos);
        workbook.close();
        fos.close();
    }
}
