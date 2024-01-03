package services;

import dao.IProdutoDAO;
import domain.Cliente;
import domain.Produto;
import exceptions.DAOException;
import services.generic.GenericService;

public abstract class ProdutoService extends GenericService<Produto, String> implements IProdutoService{
    public ProdutoService(IProdutoDAO dao) {
        super(dao);
    }
}
