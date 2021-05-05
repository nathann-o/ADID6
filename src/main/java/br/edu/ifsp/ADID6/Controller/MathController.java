package br.edu.ifsp.ADID6.Controller;

import br.edu.ifsp.ADID6.math.SimpleMath;
import br.edu.ifsp.ADID6.request.converters.NumberConverter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsp.ADID6.exeption.ResourceNotFoundException;



@RestController
public class MathController {

    private SimpleMath math = new SimpleMath();

    @RequestMapping(value="/sum/{numberOne}/{numberTwo}", method= RequestMethod.GET)
    public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception{
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)){
            throw new ResourceNotFoundException("Por favor entre com um valor numérico!");
        }
        return math.sum(NumberConverter.convertToDoble(numberOne), NumberConverter.convertToDoble(numberTwo));
    }

    @RequestMapping(value="/subtraction/{numberOne}/{numberTwo}", method= RequestMethod.GET)
    public Double subtraction(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception{
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)){
            throw new ResourceNotFoundException("Por favor entre com um valor numérico!");
        }
        return math.subtraction(NumberConverter.convertToDoble(numberOne), NumberConverter.convertToDoble(numberTwo));
    }

    @RequestMapping(value="/multiplication/{numberOne}/{numberTwo}", method= RequestMethod.GET)
    public Double multiplication(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception{
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)){
            throw new ResourceNotFoundException("Por favor entre com um valor numérico!");
        }
        return math.multiplication(NumberConverter.convertToDoble(numberOne), NumberConverter.convertToDoble(numberTwo));
    }

    @RequestMapping(value="/division/{numberOne}/{numberTwo}", method= RequestMethod.GET)
    public Double division(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception{
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)){
            throw new ResourceNotFoundException("Por favor entre com um valor numérico!");
        }
        return math.division(NumberConverter.convertToDoble(numberOne), NumberConverter.convertToDoble(numberTwo));
    }

    @RequestMapping(value="/mean/{numberOne}/{numberTwo}", method= RequestMethod.GET)
    public Double mean(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception{
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)){
            throw new ResourceNotFoundException("Por favor entre com um valor numérico!");
        }
        return math.mean(NumberConverter.convertToDoble(numberOne), NumberConverter.convertToDoble(numberTwo));
    }

    @RequestMapping(value="/squareRoot/{number}", method= RequestMethod.GET)
    public Double squareRoot(@PathVariable("number") String number) throws Exception{
        if(!NumberConverter.isNumeric(number) ){
            throw new ResourceNotFoundException("Por favor entre com um valor numérico!");
        }
        return math.squareRoot(NumberConverter.convertToDoble(number));
    }



}
