package edu.beca.es.eoi.repositoryImpl;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import edu.beca.es.eoi.entity.Person;
import edu.beca.es.eoi.entity.User;
import edu.beca.es.eoi.repository.PersonRepository;

public class PersonRepositoryExcelImpl implements PersonRepository {

	private static final Properties properties = new Properties();
	private static final Logger logger = Logger.getLogger(PersonRepositoryExcelImpl.class);

	public void save(Person e) {

	}

	public Person update(Person e) {
		return null;
	}

	public Person read(String sf) {
		Map<String, User> usuarios = new HashMap<String, User>();
		Workbook workbook = null;
		try {
			workbook = new XSSFWorkbook(new File(properties.getProperty("excelsource.url")));

			Sheet sheet = workbook.getSheet("Usuarios");

			int i = 0;
			for (Row row : sheet) {
				if (i != 0) {

					User user = new User();
					user.setUsername(row.getCell(0).getStringCellValue());
					user.setPassword(row.getCell(1).getStringCellValue());
					user.setName(row.getCell(2).getStringCellValue());
					user.setSurname(row.getCell(3).getStringCellValue());

					usuarios.put(user.getUsername(), user);
				}
				i++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				workbook.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return usuarios.get(sf);
	}

	public boolean delete(Person e) {

		Map<String, User> usuarios = new HashMap<String, User>();

		Workbook workbook = null;
		User user = new User();
		boolean removeOK = false;
		try {
			workbook = new XSSFWorkbook(new File(properties.getProperty("excelsource.url")));

			Sheet sheet = workbook.getSheet("Usuarios");

			int i = 0;
			for (Row row : sheet) {
				if (i != 0) {

					user.setUsername(row.getCell(0).getStringCellValue());
					user.setPassword(row.getCell(1).getStringCellValue());
					user.setName(row.getCell(2).getStringCellValue());
					user.setSurname(row.getCell(3).getStringCellValue());

					usuarios.put(user.getUsername(), user);
				}
				i++;
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				workbook.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		usuarios.remove(((User) e).getUsername(), (User) e);
		for (User userAUX : usuarios.values()) {
			if (userAUX.getUsername().equalsIgnoreCase(((User) e).getUsername())) {
				removeOK = false;
			} else {
				removeOK = true;
			}
		}
		return removeOK;

	}
}
