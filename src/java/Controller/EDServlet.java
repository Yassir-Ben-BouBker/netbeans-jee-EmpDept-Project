/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import Dao.DepartementFacade;
import Dao.EmployeFacade;
import Entity.Departement;
import Entity.Employe;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dell
 */
public class EDServlet extends HttpServlet {
    @EJB(mappedName="DepartementFacade")
    private DepartementFacade daoDep;
    @EJB(mappedName="DepartementFacade")
    private EmployeFacade daoEmp;



    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        
        request.getRequestDispatcher("index.jsp").forward(request, response);

                    
        String action = request.getParameter("action");
        System.out.println(action);
        if(action.equalsIgnoreCase("CreateEmploye")){
             this.CreateEmployee(request,response);
        }else if(action.equalsIgnoreCase("ModifyEmploye")){
             this.ModifyEmploye(request,response);
        }else if(action.equalsIgnoreCase("UpdateEmploye")){
             this.EditEmploye(request,response);
        }else if(action.equalsIgnoreCase("SaveEmploye")){
             this.SaveEmploye(request,response);
        }else if(action.equalsIgnoreCase("SaveDepartement")){
             this.SaveDepartement(request,response);
        }else if(action.equalsIgnoreCase("DeleteEmploye")){
             this.DeleteEmploye(request,response);
        }else if(action.equalsIgnoreCase("Employes")){
            this.AllEmployes(request,response);
        }else if(action.equalsIgnoreCase("CreateDepartement")){
            this.CreateDepartement(request,response);
        }else if(action.equalsIgnoreCase("UpdateDepartement")){
            this.EditDepartement(request,response);
        }else if(action.equalsIgnoreCase("ModifyDepartement")){
            this.ModifyDepartement(request,response);
        }else if(action.equalsIgnoreCase("DeleteDepartement")){
            this.DeleteDepartement(request,response);
        }else if(action.equalsIgnoreCase("Departements")){
            this.AllDepartements(request,response);
        }else{
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
 
    private void CreateEmployee(HttpServletRequest request, HttpServletResponse response) 
     throws ServletException, IOException {
        String departement_id = request.getParameter("departement_id");
        Departement departement = null;
        if(departement_id != null){
            departement = daoDep.FindByCode(departement_id);
        }
        request.setAttribute("departement", departement);
        request.getRequestDispatcher("CreateEmploye.jsp").forward(request, response);
    }
    
    private void SaveEmploye(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String name = request.getParameter("name");
        String idemp = request.getParameter("code");
        String departement_id = request.getParameter("idDep");
        Double salaire = Double.parseDouble(request.getParameter("salaire"));
        
        System.out.println(departement_id);
        Departement departement = daoDep.FindByCode(departement_id);
        
        Employe employe = new Employe(idemp,name,salaire);
        employe.setRefDept(departement);
        daoEmp.addEmploye(employe);
        
        this.AllEmployes(request,response);
    }

    private void AllDepartements(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        List<Departement> departements = daoDep.findAll();
        request.setAttribute("departements", departements);
        request.getRequestDispatcher("Departements.jsp").forward(request, response);
    }


    private void DeleteDepartement(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String id = request.getParameter("id");
                
        daoDep.DeleteByCode(id);
        
        
        this.AllDepartements(request, response);
    }

    private void EditDepartement(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String code = request.getParameter("id");
                
        Departement departement = daoDep.FindByCode(code);
        
        request.setAttribute("departement", departement);
        request.getRequestDispatcher("EditDepartement.jsp").forward(request, response);
    }

    private void CreateDepartement(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.getRequestDispatcher("CreateDepartement.jsp").forward(request, response);
    }

    private void AllEmployes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        List<Employe> employes = daoEmp.findAll();
        
        request.setAttribute("employes", employes);
        request.getRequestDispatcher("Employes.jsp").forward(request, response);
    }



    private void DeleteEmploye(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String id = request.getParameter("id");
                
        daoEmp.deleteEmploye(daoEmp.findByCode(id));
        
        this.AllDepartements(request, response);
    }

    private void EditEmploye(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
         
        String code = request.getParameter("id");        
        Employe employe = daoEmp.findByCode(code);
        
        request.setAttribute("employe", employe);
        request.getRequestDispatcher("EditEmploye.jsp").forward(request, response);
    }

    

    private void SaveDepartement(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String name = request.getParameter("name");
        String ref = request.getParameter("ref");
                
        Departement departement = new Departement();
        departement.setNom(name);
        departement.setIdDept(ref);
        
        System.out.println(departement);
        daoDep.add(departement);

        this.AllDepartements(request, response);
    }

    private void ModifyEmploye(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String name = request.getParameter("name");
        String code = request.getParameter("id");
        String ref = request.getParameter("ref");
        Double salaire = Double.parseDouble(request.getParameter("salaire"));
        System.out.println("REFERENCE : "+ref);
                
        Departement departement;
        departement = new Departement();
        departement = daoDep.FindByCode(ref);
        Employe employe = new Employe();
        employe.setNom(name);
        employe.setIdEmp(code);
        employe.setSalaire(salaire);
        employe.setRefDept(departement);
        daoEmp.updateEmploye(employe);

        this.AllEmployes(request, response);
    }

    private void ModifyDepartement(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String name = request.getParameter("name");
        String ref = request.getParameter("code");
        System.out.println("REFERENCE : "+ref);
        
        Departement departement = new Departement();
        departement.setNom(name);
        departement.setIdDept(ref);
        
        System.out.println(departement);
        daoDep.update(departement);

        this.AllDepartements(request, response);
    }

    
}
