package dao;

import dao.generic.GenericDAO;
import domain.Produto;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProdutoDAO extends GenericDAO<Produto, String> implements IProdutoDAO {
    public ProdutoDAO() {
        super();
    }
    @Override
    public Class<Produto> getTipoClasse() {
        return Produto.class;
    }

    @Override
    public void atualizarDados(Produto entity, Produto entityCadastrado) {
        entityCadastrado.setCodigo(entity.getCodigo());
        entityCadastrado.setDescricao(entity.getDescricao());
        entityCadastrado.setNome(entity.getNome());
        entityCadastrado.setValor(entity.getValor());
    }

    @Override
    protected String getQueryInsercao() {
        StringBuilder sb = new StringBuilder();
        sb.append("insert into tb_produto ");
        sb.append("(id, codigo, nome, descricao, valor)");
        sb.append("values (nextval('sq_produto'),?,?,?,?)");
        return sb.toString();
    }

    @Override
    protected String getQueryExclusao() {
        return "delete from tb_produto where codigo = ?";
    }

    @Override
    protected String getQueryAtualizacao() {
        StringBuilder sb = new StringBuilder();
        sb.append("update tb_produto ");
        sb.append("set codigo = ?,");
        sb.append("nome = ?,");
        sb.append("descricao = ?,");
        sb.append("valor = ?");
        sb.append("where codigo = ?");
        return sb.toString();
    }

    @Override
    protected void setParametrosQueryInsercao(PreparedStatement stmInsert, Produto entity) throws SQLException {
        stmInsert.setString(1, entity.getCodigo());
        stmInsert.setString(2, entity.getNome());
        stmInsert.setString(3, entity.getDescricao());
        stmInsert.setBigDecimal(4, entity.getValor());
    }

    @Override
    protected void setParametrosQueryExclusao(PreparedStatement stmExclusao, String valor) throws SQLException {
        stmExclusao.setString(1, valor);
    }

    @Override
    protected void setParametrosQueryAtualizacao(PreparedStatement stmUpdate, Produto entity) throws SQLException {
        stmUpdate.setString(1, entity.getCodigo());
        stmUpdate.setString(2, entity.getNome());
        stmUpdate.setString(3, entity.getDescricao());
        stmUpdate.setBigDecimal(4, entity.getValor());
        stmUpdate.setString(5, entity.getCodigo());
    }

    @Override
    protected void setParametrosQuerySelect(PreparedStatement stmExclusao, String valor) throws SQLException {
        stmExclusao.setString(1, valor);
    }
}
