/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.saude.util;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.*;



public class ReportsUtil {

    public void gerarRelatorioPDF(Map parametros, String caminho, Connection conn, String nArquivo) throws IOException, JRException, ClassNotFoundException, SQLException {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
        response.setContentType("application/pdf");
        response.setHeader("Content-disposition", "inline;filename="+nArquivo);
        ServletOutputStream servletOutputStream = response.getOutputStream();
        InputStream reportStream = context.getExternalContext().getResourceAsStream(caminho);
        JasperRunManager.runReportToPdfStream(reportStream, servletOutputStream, parametros, conn);
        servletOutputStream.flush();
        servletOutputStream.close();
        context.responseComplete();
    }
}
