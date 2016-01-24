package br.com.imobiliaria.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.jdbc.ReturningWork;

import br.com.imobiliaria.util.cdi.CDIServiceLocator;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

public class Relatorio implements Serializable {

	private static final long serialVersionUID = 1L;

	public void gerar(String caminho, Map<String, Object> parametros) throws JRException, IOException {
		EntityManager manager = CDIServiceLocator.getBean(EntityManager.class);
		Session session = manager.unwrap(Session.class);

		Connection conexao = session.doReturningWork(new ReturningWork<Connection>() {
			@Override
			public Connection execute(Connection connection) throws SQLException {
				return connection;
			}
		});

		JasperPrint relatorio = JasperFillManager.fillReport(caminho, parametros, conexao);
		
		File pdf = File.createTempFile("output.", ".pdf");
		JasperExportManager.exportReportToPdfStream(relatorio, new FileOutputStream(pdf));
	}

}
