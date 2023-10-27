<%-- 
    Document   : index
    Created on : Oct 14, 2023, 2:22:23 PM
    Author     : iarsk
--%>

<%@page import="java.util.Enumeration"%>
<%@page import="model.Products"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "model.Products"%>
<%@page import = "controller.CallProductTable"%>
<!DOCTYPE html>
<html>
    <style>
        body {
          background-color: black;
          color: white;
        }

        table {
          width: 80%;
          margin: 0 auto;
          border-collapse: collapse;
        }

        table, th, td {
          border: 1px solid white;
        }

        th, td {
          padding: 10px;
        }
    </style>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <center>
        
        <h1>DVD Catalog</h1>      
        <form name="AddToCartForm" action="AddToShoppingCart" method="POST">        
            <table border="1" width="30%" cellspacing="1" cellpadding="1" >
                <thead>
                    <tr>
                        <th>DVD names</th>
                        <th>Rating</th>
                        <th>Year</th>
                        <th>Price/Unit</th>
                        <th>Quantity</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        List<Products> pdList = CallProductTable.findAllProduct();
                        for(Products pd : pdList){
                    %>
                    <tr>
                        <td>
                            <%= "<input type=\"checkbox\" name=\"CBDVDName\" value=\"" + pd.getMovie() + " \" id = \""+ pd.getMovie() +"\" />"%>
                            <%= pd.getMovie() %>
                        </td>
                        <td>
                            <%= pd.getRating() %>
                        </td>
                        <td>
                            <div style="text-align: center;">
                                <%= pd.getYearcreate() %>
                        </div>
                        </td>
                        <td>
                            <div style="text-align: center;">
                                <%= pd.getPrice() %>
                            </div>
                        </td>
                        <td>
                            <div style="text-align: center;">
                                <%= "<input type=\"text\" name=\"" + pd.getMovie() + "\" value=\"\"  pattern = \"[1-9]+\" size=\"5\" style=\"text-align: center;\" id = \""+ pd.getMovie() +"_Quantity\" />"%>
                            </div>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
     
            <input type="submit" value="Add To Cart" name="BTAddToCart" />
            
        </form>
        </center>
            <% 
                // get current session --> session
                session = request.getSession(); 
                if(!session.isNew()){ //check not new session
                    Enumeration<String> sessionAttrList = session.getAttributeNames(); // get all attribute --> sessionAttrList
                    out.println("<script>");
                    while(sessionAttrList.hasMoreElements()){
                        String singleAttr = sessionAttrList.nextElement(); // attrName --> movie name
                        if(!singleAttr.contains("WELD_S_HASH")){ 
                            out.println("document.getElementById(\""+ singleAttr +"\").checked = true");
                            out.println("document.getElementById(\""+ singleAttr +"_Quantity\").value =\"" + session.getAttribute(singleAttr) + "\"" );
                        }
                   } 
                    out.println("</script>");
                }
            %>
    </body>
</html>
