package com.example.app;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class TestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <meta charset=\"utf-8\">\n" +
                "    <title>To-Do</title>\n" +
                "    <style>\n" +
                "        body{\n" +
                "            margin: 0;\n" +
                "        }\n" +
                "        a{\n" +
                "            color: black;\n" +
                "            text-decoration: none;\n" +
                "        }\n" +
                "        h1{\n" +
                "            font-size: 45px;\n" +
                "            text-align: center;\n" +
                "            border-bottom: 2px solid gray;\n" +
                "            margin: 0;\n" +
                "            padding:20px;\n" +
                "        }\n" +
                "        ol{\n" +
                "            border-right: 2px solid gray;\n" +
                "            width: 100px;\n" +
                "            margin: 0;\n" +
                "            padding: 20px;\n" +
                "        }\n" +
                "        #grid{\n" +
                "            display: grid;\n" +
                "            grid-template-columns: 150px 1fr;\n" +
                "        }\n" +
                "        #grid ol{\n" +
                "            padding-left: 33px;\n" +
                "        }\n" +
                "        #article{\n" +
                "            padding-left: 25px;\n" +
                "        }\n" +
                "\n" +
                "        @media(max-width:800px) {\n" +
                "            #grid{\n" +
                "                display: block;\n" +
                "            }\n" +
                "            ol{\n" +
                "                border-right: none;\n" +
                "            }\n" +
                "            h1{\n" +
                "                border-bottom: none;\n" +
                "            }\n" +
                "        }\n" +
                "    </style>\n" +
                "\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                "<h1><a>To Do List</a></h1>\n" +
                "<div id=\"grid\">\n" +
                "    <ol>\n" +
                "        <li><a href=\"http://localhost:8080/ToDoList/test\">Things</a></li>\n" +
                "        <li><a href=\"http://localhost:8080/ToDoList/test\">PROJECT</a></li>\n" +
                "    </ol>\n" +
                "    <div id=\"article\">\n" +
                "        <h2>Things</h2>\n" +
                "        <p>MAKE \"To Do List\"</p>\n" +
                "    </div>\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>");
    }
}
