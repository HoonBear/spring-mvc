package soncompany.sonproject.controller;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(name = "name", required = false) String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name, @RequestParam("age") int age) {
        return "hello" + name + " ," + age;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public JSONObject HelloApi(@RequestParam("name") String name) {
        JSONObject jsonObject = new JSONObject();


        Hello hello = new Hello();
        hello.setName(name);


        jsonObject.put("status", "200");
        jsonObject.put("data", hello);

        return jsonObject;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
