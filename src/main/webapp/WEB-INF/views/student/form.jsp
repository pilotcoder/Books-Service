<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form method="post" modelAttribute="student">
    <h2>Formularz dodawania studenta: </h2>
    <br>
    <div>
        Imię: <form:input path="firstName"/>
    </div>
    <div>
        Nazwisko: <form:input path="lastName"/>
    </div>
    <div>
        Płeć: Mężczyzna: <form:radiobutton path="gender" value="M"/> Kobieta: <form:radiobutton path="gender"
                                                                                                value="F"/>
    </div>
    <div>
        Kraj: <form:select path="country" items="${countries}"/>
    </div>
    <div>
        Notatki: <form:textarea path="notes" rows="3" cols="20"/>
    </div>
    <div>
        <br>
        Dodać do listy mailingowej? <form:checkbox path="mailingList"/>
        <br>
    </div>
    <div>
        Języki programowania:
        <br>
        <form:select path="programmingSkills">
            <form:option value="-" label="--Please Select--"/>
            <form:options items="${programmingSkills}"/>
        </form:select>

    </div>
    <div>
        Zainteresowania: <form:checkboxes items="${hobbies}" path="hobbies"/>
    </div>
    <div>
        <input type="submit" value="Dodaj Studenta">
    </div>


</form:form>

</body>
</html>