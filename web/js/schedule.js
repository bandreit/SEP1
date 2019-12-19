$(document).ready(() => {
  const fetchData = (url, cb) => {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
      if (this.readyState == 4 && this.status == 200) {
        cb(this.responseXML);
      }
    };
    xhttp.open("GET", url, true);
    xhttp.send();
  };

  const getInformation = (element, field) => {
    let currentTag = field;
    let currentElement = element;

    if (currentTag.includes(".")) {
      currentTag = currentTag.split(".");
      currentElement = element.getElementsByTagName(currentTag[0])[0];

      currentTag = currentTag.slice(1).shift(".");
      return getInformation(currentElement, currentTag);
    }

    return currentElement.getElementsByTagName(currentTag)[0].childNodes[0]
      .nodeValue;
  };

  const formatExamDate = (element, field) => {
    const day = getInformation(element, `${field}.day`);
    const month = getInformation(element, `${field}.month`);
    const year = getInformation(element, `${field}.year`);
    const hour = getInformation(element, `${field}.hour`);
    const minutes = getInformation(element, `${field}.minutes`);

    return `${day}/${month}/${year} ${hour}:${minutes}`;
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
      const exams = data.getElementsByTagName("exams");
      $("#scheduleTable tbody").empty();

      for (let i = 0; i < exams.length; i++) {
        const course = getInformation(exams[i], "course.name");
        const startDate = formatExamDate(exams[i], "date1");
        const endDate = formatExamDate(exams[i], "date2");
        const classroom = getInformation(exams[i], "classroom.number");

        const examiner = getInformation(exams[i], "examiner.initials");
        const teacher = getInformation(exams[i], "teacher.initials");
        const examiners = `${examiner}, ${teacher}`;

        const isOral = getInformation(exams[i], "course.isOral") == "true";
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
    const courses = data.getElementsByTagName("courses");

    for (let i = 0; i < courses.length; i++) {
      const name = getInformation(courses[i], "name");

      const row = `<a class="dropdown-item" href="#">${name}</a>`;
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
