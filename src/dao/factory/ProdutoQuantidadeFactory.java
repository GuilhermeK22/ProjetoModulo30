package dao.factory;

import domain.Produto;
import domain.ProdutoQuantidade;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProdutoQuantidadeFactory {

    public static ProdutoQuantidade convert(ResultSet rs) throws SQLException {
        Produto prod = ProdutoFactory.convert(rs);
        ProdutoQuantidade prodQ = new ProdutoQuantidade();
        prodQ.setProduto(prod);
        prodQ.setId(rs.getLong("id"));
        prodQ.setQuantidade(rs.getInt("quantidade"));
        prodQ.setValorTotal(rs.getBigDecimal("valor_total"));
        return prodQ;
    }
}
