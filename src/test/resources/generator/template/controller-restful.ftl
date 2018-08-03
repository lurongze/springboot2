package ${basePackage}.controller;

import ${basePackage}.core.Result;
import ${basePackage}.core.ResultGenerator;
import ${basePackage}.model.${modelNameUpperCamel};
import ${basePackage}.service.${modelNameUpperCamel}Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Condition;
import java.util.List;

/**
* Created by ${author} on ${date}.
*/
@RestController
@RequestMapping("${baseRequestMapping}")
public class ${modelNameUpperCamel}Controller {
    <#--@Autowired-->
    <#--private ${modelNameUpperCamel}Service ${modelNameLowerCamel}Service;-->

    private final ${modelNameUpperCamel}Service ${modelNameLowerCamel}Service;
    @Autowired
    public UserRoleController(${modelNameUpperCamel}Service ${modelNameLowerCamel}Service) {
        this.${modelNameLowerCamel}Service = ${modelNameLowerCamel}Service;
    }


    @PostMapping
    public Result add(${modelNameUpperCamel} ${modelNameLowerCamel}) {
        ${modelNameLowerCamel}Service.save(${modelNameLowerCamel});
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        // ${modelNameLowerCamel}Service.deleteById(id);
        ${modelNameUpperCamel} ${modelNameLowerCamel} = ${modelNameLowerCamel}Service.findById(id);
        byte isDelete = 1;
        ${modelNameLowerCamel}.setIsDelete(isDelete);
        ${modelNameLowerCamel}Service.update(${modelNameLowerCamel});
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(${modelNameUpperCamel} ${modelNameLowerCamel}) {
        ${modelNameLowerCamel}Service.update(${modelNameLowerCamel});
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        ${modelNameUpperCamel} ${modelNameLowerCamel} = ${modelNameLowerCamel}Service.findById(id);
        return ResultGenerator.genSuccessResult(${modelNameLowerCamel});
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        String orderBy = "id ASC";
        PageHelper.startPage(page, size, orderBy);
        // List<${modelNameUpperCamel}> list = ${modelNameLowerCamel}Service.findAll();
        Condition condition = new Condition(${modelNameUpperCamel}.class);
        condition.createCriteria().andEqualTo("isDelete", "0");
        // condition.and().andEqualTo("fisuse" ,"1");
        List<${modelNameUpperCamel}> list = ${modelNameLowerCamel}Service.findByCondition(condition);
        PageInfo pageInfo = new PageInfo<>(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    /**
    * @return 返回实体的结构
    */
    @GetMapping("/entity")
    public Result entity() {
        ${modelNameUpperCamel} ${modelNameLowerCamel}Entity = new ${modelNameUpperCamel}();
        ${modelNameLowerCamel}Entity.setUnionId("0");
        return ResultGenerator.genSuccessResult(${modelNameLowerCamel}Entity);
    }
}
