package es.uji.ei1027.proyecto.dao;

import java.sql.SQLException;
import java.sql.ResultSet;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import es.uji.ei1027.proyecto.domain.Periodo;

@Repository
public class PeriodoDao {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource){
		this.jdbcTemplate= new JdbcTemplate(dataSource);
	}
	
	private static final class PeridoMapper implements RowMapper<Periodo>{
		public Periodo mapRow(ResultSet rs, int rowNum) throws SQLException{
			Periodo periodo = new Periodo();
			periodo.setId_periodo(rs.getInt("id_periodo"));
			periodo.setId_propiedad(rs.getInt("id_propiedad"));
			periodo.setInicio(rs.getDate("inicio"));
			periodo.setFin(rs.getDate("fin"));
			return periodo;
		}		
	}
	
	
	public List<Periodo> getPeriodos() {
		return jdbcTemplate.query("select id_periodo, id_propiedad, inicio, fin from periodo", new PeridoMapper());
	}
	
	public Periodo getPeriodo(int id_periodo) {
		return jdbcTemplate.queryForObject("select id_periodo, id_propiedad, inicio,fin from periodo where id_periodo=?", new Object[] {id_periodo}, new PeridoMapper());
	}
	
	public void addPeriodo(Periodo periodo) {
		this.jdbcTemplate.update("insert into periodo(id_periodo, id_propiedad, inicio, fin) values(?, ?, ?, ?)", periodo.getId_periodo(),periodo.getId_propiedad(),periodo.getInicio(),periodo.getFin());
	}
	
	public void updatePeriodo(Periodo periodo) {
		this.jdbcTemplate.update("update periodo set id_propiedad=?,inicio=?,fin=? where id_periodo=?", periodo.getId_propiedad(),periodo.getInicio(),periodo.getFin(),periodo.getId_periodo());
	}
	
	public void deletePeriodo(Periodo periodo) {
		this.jdbcTemplate.update("DELETE FROM periodo WHERE id_periodo=?", periodo.getId_periodo());
	}
	
	public void deletePeriodo(int id_periodo) {
		this.jdbcTemplate.update("DELETE FROM periodo WHERE id_periodo=?", id_periodo);
	}
}
