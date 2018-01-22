package com.z.precios.Service

import com.z.precios.Model.Product
import com.z.precios.Util.asLocalDateTime
import org.apache.commons.lang3.StringUtils
import org.apache.poi.util.StringUtil
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.io.File
import java.io.FileInputStream
import java.text.Normalizer


@Service
class ExcelService {
    @Value("\${excel.path}") private val EXCEL_PATH: String = ""
    private val HEADER = true

    fun findAll():List<Product>{
            val result = mutableListOf<Product>()
            val excelFile = FileInputStream(File(EXCEL_PATH))
            val iterator = XSSFWorkbook(excelFile).getSheetAt(0).iterator()
            while (iterator.hasNext()) {
                val currentRow = iterator.next()
                if(HEADER&&currentRow.rowNum!=0){
                    result.add(Product(currentRow.getCell(0)?.stringCellValue,
                            currentRow.getCell(1).stringCellValue,
                            currentRow.getCell(2).numericCellValue,
                            currentRow.getCell(3)?.dateCellValue?.asLocalDateTime()))
                }
            }
        return result
    }

    fun findByName(name:String) = findAll().filter { StringUtils.stripAccents(it.name).toUpperCase().contains(StringUtils.stripAccents(name).toUpperCase()) }
    fun findById(id:String)=findAll().filter { it.id==id }
}