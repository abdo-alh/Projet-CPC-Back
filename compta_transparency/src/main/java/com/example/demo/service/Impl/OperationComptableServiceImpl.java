
package com.example.demo.service.Impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.example.demo.bean.OperationComptable;
import com.example.demo.dao.OperationComptableDao;
import com.example.demo.service.facade.OperationComptableService;
import com.example.demo.service.util.ExcelUtil;
import com.example.demo.service.util.NumberUtil;
import com.example.demo.service.util.SearchUtil;

@Service
public class OperationComptableServiceImpl implements OperationComptableService {

	@Autowired
	private OperationComptableDao operationcomptableDao;
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<OperationComptable> findGroupeByCompteComptable(Date dateDebut, Date dateFin, int code) {
		return operationcomptableDao.findGroupeByCompteComptable(dateDebut, dateFin, code);
	}
	
	@Override
	public List<OperationComptable> findGroupeBySousClasseCompteComptable(Date dateDebut, Date dateFin,
			String codeCompteComptable) {
		return operationcomptableDao.findGroupeBySousClasseCompteComptable(dateDebut, dateFin, codeCompteComptable);
	}
	
	@Override
	public List<OperationComptable> findGroupeByClasseCompteComptable(Date dateDebut, Date dateFin,
			String codeCompteComptable) {
		return operationcomptableDao.findGroupeByClasseCompteComptable(dateDebut, dateFin, codeCompteComptable);
	}
	
	@Override
    public List<Object[]> findGroupeByClasseComptable(Date dateDebut, Date dateFin, String code) {
		return findOperationComptableCpc("compteComptable.sousClasseComptable.classeComptable", dateDebut, dateFin, code);
	}


	private List<Object[]> findOperationComptableCpc(String groupeByAttribute, Date dateDebut, Date dateFin, String code) {
		String query = "SELECT o." + groupeByAttribute + ", SUM(o.montant) FROM OperationComptable o WHERE 1=1 AND o.compteComptable.code LIKE '" + code + "%'";
		query += SearchUtil.addConstraintMinMaxDate("o", "dateOperationComptable", dateDebut, dateFin);
		query += " GROUP BY o." + groupeByAttribute;
		List<Object[]> res = entityManager.createQuery(query).getResultList();
		return res;
	}

	@Override
	public OperationComptable save(OperationComptable operationcomptable) {

		if (operationcomptable == null) {
			return null;
		} else {
			operationcomptableDao.save(operationcomptable);
			return operationcomptable;
		}
	}

	@Override
	public List<OperationComptable> findAll() {
		return operationcomptableDao.findAll();
	}

	@Override
	public OperationComptable findById(Long id) {
		return operationcomptableDao.getOne(id);
	}

	@Override
	public int delete(OperationComptable operationcomptable) {
		if (operationcomptable == null) {
			return -1;
		} else {
			operationcomptableDao.delete(operationcomptable);
			return 1;
		}
	}

	@Override
	public void deleteById(Long id) {
		operationcomptableDao.deleteById(id);
	}
	
	@Override
	public Resource generateExcelFile(List<OperationComptable> operationComptables) {
        XSSFWorkbook workbook = new XSSFWorkbook();


        CellStyle headerStyle = workbook.createCellStyle();
        XSSFFont font = (workbook).createFont();
        font.setFontName("Arial");
        font.setFontHeightInPoints((short) 10);
        font.setBold(true);
        headerStyle.setFont(font);

        List<String> headerData = Arrays.asList("Compte Comptable", "Montant");

        XSSFSheet sheet = ExcelUtil.initSheet(workbook, "Operations Comptable", null, headerData, headerStyle);

        List<List<String>> cellData = new ArrayList<>();

        CellStyle style = workbook.createCellStyle();
        style.setWrapText(true);

        for (OperationComptable operationComptable : operationComptables) {

            String compte = operationComptable.getCompteComptable() == null ? "none" : operationComptable.getCompteComptable().getCode() + " " + operationComptable.getCompteComptable().getLibelle();
            cellData.add(Arrays.asList(operationComptable.getLibelle(),
                    compte,
                    NumberUtil.toString(operationComptable.getMontant())));

        }
        ExcelUtil.fillTable(sheet, cellData, style, 1);

        return ExcelUtil.exportBlob(workbook);

    }

}
