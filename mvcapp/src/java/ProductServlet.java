import com.trg.model.ProductDataProcessor;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/products"})
public class ProductServlet extends HttpServlet {
    
     @Inject
      ProductDataProcessor dp;// = new ProductDataProcessor();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        String page = null;
        
       
        if(action==null){
            page = dp.getAll(request, response);
        }
        else if(action.equals("GetProduct")){
            page = dp.getProduct(request, response);
//            RequestDispatcher rd = request.getRequestDispatcher(page+".jsp");
//            rd.forward(request, response);
        }
        else
        {
            page = dp.saveProduct(request, response);
        }
       

        RequestDispatcher rd = request.getRequestDispatcher(page+".jsp");
        rd.forward(request, response);
    }
}
