<%-- 
    Document   : movie
    Author     : aben
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <script>
           /*
            * This funciton is used to send and received information from the 
            * MovieServlet. It can be called in three differen ways.
            * 
            * First: getData(invId, null,null,'inventory'); //Get movie information by inventory id
            * Second: getData(null,storeID,title,'store'); //Get movie information by store id and title
            * Third: getData(null,null,'movie title','title'); //Get movie information by movie title
            * 
            * @param {type} invId {id integer or null}
            * @param {type} storeId {id integer or null}
            * @param {type} title {title string or null}
            * @param {type} type {'store', 'inventory', or 'title'}
            * @returns {Based on type return movie information}
            */
            function getDatda(invId,storeId, title, type) {
                   
                    $.ajax({
                        url: "MovieServlet",
                        type: "POST",
                        data: "store_id=" + storeId+ "&inv_id=" + invId + "&title=" + title + "&type=" + type,
                        success: function (data) {
                            var res = JSON.parse(data);
                            /* res variable contains the JSON array with all the information.
                             * From here the information can be displayed on the page as desired
                             * Example: $("#results").append("Title: " + res[0].title);
                             * */
                        }
                    });
            }

        </script>
    </head>
    <body>   
          <div id="results"></div>
    </body>
</html>
