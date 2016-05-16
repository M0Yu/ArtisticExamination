package com.artistic_exam.ActionForm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.artisitc_exam.Question_Bank.QuestionBank;
import com.artisitc_exam.Question_Bank.QuestionBankDAO;
import com.artisitc_exam.Question_Bank.QuestionBankId;
import com.artistic_exam.sessionFactory.HibernateSessionFactory;

public class InsertQuestionBankAction {

	private File questionBank;
	private String questionBankFileName;
	private String questionBankContentType;

	public File getQuestionBank() {
		return questionBank;
	}

	public void setQuestionBank(File questionBank) {
		this.questionBank = questionBank;
	}

	public String getQuestionBankFileName() {
		return questionBankFileName;
	}

	public void setQuestionBankFileName(String questionBankFileName) {
		this.questionBankFileName = questionBankFileName;
	}

	public String getQuestionBankContentType() {
		return questionBankContentType;
	}

	public void setQuestionBankContentType(String questionBankContentType) {
		this.questionBankContentType = questionBankContentType;
	}

	public String execute() {
		Session session = HibernateSessionFactory.getSession();
		Transaction tran = null;

		try {
			tran = session.beginTransaction();
			XSSFWorkbook workBook = new XSSFWorkbook(new FileInputStream(
					questionBank));
			XSSFSheet sheet = workBook.getSheet("Question_Bank");

			int rowNum = sheet.getLastRowNum() + 1;

			QuestionBankDAO dao = new QuestionBankDAO();
			QuestionBank qb = null;
			QuestionBankId id = null;

			for (int i = 1; i < rowNum; i++) {
				if (sheet.getRow(i).getCell(0) == null)
					continue;
				qb = new QuestionBank();

				id = new QuestionBankId(
						getCellValue(sheet.getRow(i).getCell(0)),
						getCellValue(sheet.getRow(i).getCell(2)));
				// qb.setQusNum(getCellValue(sheet.getRow(i).getCell(0)));
				qb.setId(id);
				qb.setQustionContent(getCellValue(sheet.getRow(i).getCell(1)));

				dao.save(qb);
			}

			tran.commit();
			return "success";
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			tran.rollback();
		} finally {
			session.close();
		}

		return "fail";
	}

	private static String getCellValue(XSSFCell cell) {
		if (cell == null) {
			return null;
		}
		if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
			return cell.getRawValue().trim();
		} else {
			return cell.getStringCellValue().trim();
		}
	}
}
