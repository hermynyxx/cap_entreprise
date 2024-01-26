<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../tag.jsp" %>
<jsp:include flush="true" page="../base.jsp"/>

 <div class="container m">
        <div class="row">

        <h1>Messages</h1>
        <c:forEach items="${reviewsList}" var="review">
            <div class="container">


                          <p>"${review.id}"</p>


                          <p>message créé le "${review.createdAt}" </p>



                      <"${review.description}" /td>
                    </tr>
                      </tbody>
                   </table>


           </c:forEach>
             <c:set var="page" scope="request" value="${pageReviews}"/>
               <%@ include file="component/pagination.jsp" %>
           </div>
           </div>