$(document).ready(() => {
  const fetchData = (url, cb) => {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
      if (this.readyState == 4 && this.status == 200) {
        cb(this.response);
      }
    };
    xhttp.open("GET", url, true);
    xhttp.send();
  };

  const getInformation = (text, n, field) => {
    var parser = new DOMParser();
    var xmlDoc = parser.parseFromString(text, "text/xml");
    var x = xmlDoc.getElementsByTagName(field);

    return x[n].childNodes[0].nodeValue;
  };

  /**
   * Get Tooltip text
   */
  const getTooltipText = isOral => {
    if (isOral) {
      return "Oral exams are public. The number of exam questions is proportional to the number of students and the questions cover the syllabus to a reasonable extent. When the test starts all questions must be laid out and at no time during the test can less than 3 questions be available to choose from. You draw a question, yourself. The lecturer will examine you. The external examiner can only ask clarifying questions.";
    }

    return "Written tests are tests that are administered on paper or on a computer. A test taker who takes a written test could respond to specific items by writing or typing within a given space of the test or on a separate form or document.";
  };

  /**
   * Fetch exams
   */
  const fetchExams = (filterCourse = null) => {
    fetchData("../data/ExamsList.xml", data => {
      const examsLength = data.split("<Exam>").length - 1;
      $("#scheduleTable tbody").empty();

      for (let i = 0; i < examsLength; i++) {
        const course = getInformation(data, i, "Course");
        const startDate = getInformation(data, i, "StartDate");
        const endDate = getInformation(data, i, "EndDate");
        const classroom = getInformation(data, i, "ClassRoom");
        const examiners = getInformation(data, i, "Examiners");
        const isOral = getInformation(data, i, "IsOral") == "true";
        const examType = isOral ? "Oral" : "Written";

        if (filterCourse) {
          if (!course.includes(filterCourse)) {
            continue;
          }
        }

        const row = `
        <tr>
            <th scope="row">${course}</th>
            <td>${startDate}</td>
            <td>${endDate}</td>
            <td>${classroom}</td>
            <td>${examiners}</td>
            <td>
              <a href="#" data-toggle="tooltip" data-placement="bottom" title="${getTooltipText(
                isOral
              )}">${examType}</a>
            </td>
        </tr>
      `;

        $("#scheduleTable tbody").append(row);
        $('[data-toggle="tooltip"]').tooltip();
      }
    });
  };

  fetchExams();

  /**
   * Fetch courses
   */
  fetchData("../data/CoursesList.xml", data => {
    const coursesLength = data.split("<Course>").length - 1;

    for (let i = 0; i < coursesLength; i++) {
      const Name = getInformation(data, i, "Name");

      const row = `<a class="dropdown-item" href="#">${Name}</a>`;
      $(".dropdown-menu").append(row);
    }
  });

  /**
   * Filter
   */
  $("#scheduleDropdown").on("show.bs.dropdown", function() {
    $(".dropdown-item").click(function(e) {
      e.preventDefault();

      if ($(this).attr("id") === "resetFilters") {
        fetchExams();
        return;
      }

      fetchExams($(this).text());
    });
  });
});
