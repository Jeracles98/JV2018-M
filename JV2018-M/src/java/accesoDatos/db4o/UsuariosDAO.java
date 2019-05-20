/** 
 * Proyecto: Juego de la vida.
 * Versión de UsuariosDAO que utiliza la base de datos db4o.
 * @since: prototipo2.1
 * @source: UsuariosDAO.java 
 * @version: 2.1 - 2019/05/20
 * @author: Grupo 2
 * @author: Javier Muñoz Iniesta
 * @author: Jose Manuel Ibáñez Sola-Belando
 * @author: Juan Carlos Peña Fernández
 * @author: Nilo Gómez Fernández
 * @author: Pablo Muelas Ballesta
 * @author: Pablo Meseguer Lax
 * @author: ajp
 */

package accesoDatos.db4o;


import java.util.List;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;

import accesoDatos.DatosException;
import accesoDatos.OperacionesDAO;
import modelo.Usuario;


public class UsuariosDAO implements OperacionesDAO {
	
	//Singleton.
	private static UsuariosDAO instance;
	
	//Base de Datos.
	private ObjectContainer db;
	
	//Constructor.
	private UsuariosDAO() {
		db = Conexion.getInstance();
	}
	
	public static UsuariosDAO getInstance() {
		if (instance == null) {
			instance = new UsuariosDAO();
		}
		return instance;
	}
	
	@Override
	public Usuario obtener(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List obtenerTodos() {
		Query query = db.query();
		query.constrain(Usuario.class);
		ObjectSet<Usuario> result = query.execute();
		return result;
	}

	@Override
	public void alta(Object obj) throws DatosException {
		// TODO Auto-generated method stub

	}

	@Override
	public Usuario baja(String id) throws DatosException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(Object obj) throws DatosException {
		// TODO Auto-generated method stub

	}

	public String toStringDatos() {
		Query query = db.query();
	    query.constrain(Usuario.class);
	    query.descend("Usuario").constraints(); 
	    ObjectSet result = query.execute();
	    return result.toString();
	}

	public String toStringId() {
		Query query = db.query();
	    query.constrain(Usuario.class);
	    query.descend("id").constraints(); 
	    ObjectSet<Usuario> result = query.execute();
	    return result.toString();
	}

	@Override
	public void borrarTodo() {
		ObjectSet<Usuario> result = db.queryByExample(Usuario.class);
		while (result.hasNext()) {
			db.delete(result.next());
		}
	}

	@Override
	public String listarDatos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String listarId() {
		// TODO Auto-generated method stub
		return null;
	}

} //class