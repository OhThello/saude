/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.saude.controle;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;

/**
 *
 * @author Aline
 */
@ManagedBean
@RequestScoped
public class RelatorioGerencialcontrole implements Serializable {

    private Date datainicio;
    private Date datafim;

    @Resource(mappedName = "saudeJNDI")
    private DataSource dataSource;

    public void gerarRelatorio(String arquivo) throws IOException, JRException, SQLException {
        Map parametros = new HashMap();
        parametros.put("dataInicio", datainicio);
        parametros.put("dataFim", datafim);

        HttpServletResponse resposta;
        FacesContext contexto = FacesContext.getCurrentInstance();

        resposta = (HttpServletResponse) contexto.getExternalContext().getResponse();

        InputStream relatorio = contexto.getExternalContext().getResourceAsStream("/WEB-INF/relatorio/"+arquivo+".jasper");

        JasperRunManager.runReportToPdfStream(relatorio, resposta.getOutputStream(), parametros, dataSource.getConnection());
        resposta.getOutputStream().flush();
        resposta.getOutputStream().close();
        contexto.responseComplete();

    }

  

    public Date getDatainicio() {
        return datainicio;
    }

    public void setDatainicio(Date datainicio) {
        this.datainicio = datainicio;
    }

    public Date getDatafim() {
        return datafim;
    }

    public void setDatafim(Date datafim) {
        this.datafim = datafim;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

}
