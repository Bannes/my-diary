var global_classNumber;
var global_classLetter;
var global_subject;

window.addEventListener("load", function(){
    getListOfClassNumbers();

});


var classNumberId = document.getElementById("ClassNumberId_gradeBook");
classNumberId.addEventListener("click", function() {
        var classNumber = $("#ClassNumberId_gradeBook .select-selected").text();
        //because letter won't be selected for this class
        //and   this method      getListOfSubjectsForCertainClassNumberAndClassLetter()
        //won't be called
        global_classLetter=undefined;
        getListOfClassLetters(classNumber);
    }
);



var classLetterId = document.getElementById("ClassLetterId_gradeBook");
classLetterId.addEventListener("click", function() {

        global_classNumber = $("#ClassNumberId_gradeBook .select-selected").text();
        global_classLetter = $("#ClassLetterId_gradeBook .select-selected").text();


        if(global_classNumber!==undefined && global_classLetter!==undefined){
            getListOfSubjectsForCertainClassNumberAndClassLetter();
        }

    }
);


var subjectId = document.getElementById("SubjectId_gradeBook");
subjectId.addEventListener("click", function() {

        global_classNumber = $("#ClassNumberId_gradeBook .select-selected").text();
        global_classLetter = $("#ClassLetterId_gradeBook .select-selected").text();
        global_subject = $("#SubjectId_gradeBook .select-selected").text();

      /*  console.log(global_classNumber);
        console.log(global_classLetter);
        console.log(global_subject);*/

        if(global_classNumber!==undefined && global_classLetter!==undefined && global_subject!==undefined){
            getListOfKidsForCertainGradeBook();
        }

    }
);





function getListOfClassNumbers(){
    $.ajax({
        method: "GET",
        url: "/getListOfClassNumbers",
        processData: false, //prevent jQuery from automatically transforming the data into a query string
        contentType: false,
        cache: true,
        timeout: 60000000,
        success: function (result) {
            var data=result.data;
            //First element by default will be selected
            //And we pass it to get list of letters for this class
            var classNumber=result.data[0];


            if (result.status==="success"){
                var y = document.getElementById("select_ClassNumberId_gradeBook");


                var i=0;
                for(i;i<result.data.length;i++){
                    var option = document.createElement("option");
                    option.text = result.data[i];
                    y.add(option);

                }
                getListOfClassLetters(classNumber);

            }

            if (result.status==="failure"){
                console.log("failure");

            }

        },
        error: function(e) {

        }
    });

}

function getListOfClassLetters(classNumber) {
    $('#select_ClassLetterId_gradeBook option').each(function() {
        $(this).remove();
    });

    $.ajax({
        method: "GET",
        url: "/getListOfClassLetters/" + classNumber,
        processData: false, //prevent jQuery from automatically transforming the data into a query string
        contentType: false,
        cache: true,
        timeout: 60000000,
        success: function (result) {

            var x = document.getElementById("select_ClassLetterId_gradeBook");

            var temroryOption=document.createElement("option");
            temroryOption.text="Select Letter:";
            x.add(temroryOption);

            var i=0;
            for(i;i<result.data.length;i++){
                var option = document.createElement("option");
                option.text = result.data[i];
                x.add(option);
            }
            getListOfSubjects();
            /*   if(global_classNumber===undefined && global_classLetter===undefined){
               }else {
                   getListOfSubjectsForCertainClassNumberAndClassLetter();
               }*/

        },
        error: function (e) {

        }
    });
}

function getListOfSubjects() {


    $('#select_SubjectId_gradeBook option').each(function() {
        $(this).remove();
    });

    $.ajax({
        method: "GET",
        url: "/getListOfSubjects",
        processData: false, //prevent jQuery from automatically transforming the data into a query string
        contentType: false,
        cache: true,
        timeout: 60000000,
        success: function (result) {

            var x = document.getElementById("select_SubjectId_gradeBook");
            i=0;
            for(i;i<result.data.length;i++){
                var option = document.createElement("option");
                option.text = result.data[i];
                x.add(option);
            }
            $("div").remove(".select-items, .select-hide, .select-selected");
            customSelectDefault();
        },
        errorr: function (e) {
        }
    });
}

function getListOfSubjectsForCertainClassNumberAndClassLetter() {


    $('#select_SubjectId_gradeBook option').each(function() {
        $(this).remove();
    });

    $.ajax({
        method: "GET",
        url: "/getListOfSubjectForCertainClassRoom/"+global_classNumber+"/"+global_classLetter,
        processData: false, //prevent jQuery from automatically transforming the data into a query string
        contentType: false,
        cache: true,
        timeout: 60000000,
        success: function (result) {


            var x = document.getElementById("select_SubjectId_gradeBook");

            if (result.data.length===0){
                var optionDefault = document.createElement("option");
                optionDefault .text = "Nothing";
                x.add(optionDefault );
            }else{
                var temporaryOption=document.createElement("option");
                temporaryOption.text="Select Subject:";
                x.add(temporaryOption);
            }

            i=0;
            for(i;i<result.data.length;i++){
                var option = document.createElement("option");
                option.text = result.data[i];
                x.add(option);
            }



            $("div").remove(".select-items, .select-hide, .select-selected");
            customSelectDefault();
        },
        errorr: function (e) {
        }
    });
}

function getListOfKidsForCertainGradeBook() {


    $.ajax({
        method: "GET",
        url: "/getListOfKidsForCertainGradeBook/"+global_classNumber+"/"+global_classLetter+"/"+global_subject,
        processData: false, //prevent jQuery from automatically transforming the data into a query string
        contentType: false,
        cache: true,
        timeout: 60000000,
        success: function (result) {
            console.log(result);

            console.log(result.data[0].firstName + " " +result.data[0].lastName);

            createTable(result);
        },
        errorr: function (e) {
        }
    });
}
