

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Transfer</title>
        
    </head>
    <body style="display: flex; justify-content: center; align-items: center;">
        <div style="border: 2px solid black; width: 1800px;">
            <h1 style="border-bottom: 3px solid black;padding-left: 15px; padding-bottom: 15px; margin-bottom: 0;">Banking system</h1>
            <div style="float: left; border-right: 3px solid black; width: 30%; height: 1000px"  >
                <h2 style="text-align: center;">${sessionScope.user.getAccount()}</h2>
                <p style="text-align: center;"><a href="Transfer" >Transfer</a></p>  
                <p style="text-align: center;"><a href="Logout" >Logout</a></p>
            </div>
            <div style="float: right; width: 69%;" >
                <form style="padding: 20px" method="post" action="transfer">
                    <p style="font-weight: bold;">Your Balance </p> 
                    <input style="border: 1px solid black; padding: 10px;width: 300px;" name="balan" readonly="" value="${sessionScope.user.balance}" type="text">
                    <p  style="font-weight: bold;">Enter amount <span id="errorSpan" style="color: red; display: none;">Account must be less than balance</span></p>    
                    <input style="border: 1px solid black; padding: 10px;width: 300px;" placeholder="Enter Amount" oninput="checkAmount()"  type="number" name="amount">
                    <p style="font-weight: bold;">Select account to transfer </p>
                    <select style="border: 1px solid black; padding: 10px;width: 300px;" name="toAcc">
                        <option value="HoaLT9">HoaLT9</option>
                        <c:forEach var="ui" items="${ul}">
                            <option value="${ui.getAccount()}">${ui.getAccount()}</option>
                        </c:forEach>
                    </select>
                    <p style="font-weight: bold;">Transaction note </p>
                    <textarea name="note"   style="border: 1px solid black; padding: 10px;width: 300px;" rows="3">
                    </textarea>
                    <p></p>  <input disabled="" id="btnSubmit" style="padding: 15px 40px; background-color: lightgray; border: none;" type="submit" value="Transfer">
                    <p>${mess}</p>
                </form>
            </div>


       </div>
        <script>
            function checkAmount() {
                var balance = parseFloat(document.getElementsByName("balan")[0].value);
                var enteredAmount = parseFloat(document.getElementsByName("amount")[0].value);


               if (enteredAmount <= balance) {
                    document.getElementById("errorSpan").style.display = "none";
                    document.getElementById("btnSubmit").disabled = false;
                } else {
                    document.getElementById("errorSpan").style.display = "inline";
                    document.getElementById("btnSubmit").disabled = true;
                }
            }
        </script>
    </body>
</html>