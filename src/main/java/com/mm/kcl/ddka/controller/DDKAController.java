/**
 * Copyright [2017] [Maqbool Ali]
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.mm.kcl.ddka.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import weka.core.Instances;

//TODO: Auto-generated Javadoc
/**
* This class controls the features selection tasks.
*/

@Controller
public class DDKAController {
	
	private Instances data;
	
	/**
	 * Method to communicate the request/response of Web interface to open the data selection view.
	 *
	 * @return the model view
	 */
	@RequestMapping("/dataselectionview")	
	public ModelAndView showMessage() {
		ModelAndView mv = new ModelAndView("dataselector");
		return mv;
		}
		
	/**
	 * Method to communicate the request/response of Web interface with FeatureEvaluator class.
	 *
	 * @param json the data string
	 * @return the feature evaluator class object
	 * @throws Exception the exception
	 */
	@RequestMapping(value="/featuresvisualizer", method=RequestMethod.POST, produces="application/json")
	public @ResponseBody FeatureEvaluator evaluateFeatures(@RequestBody String json) throws Exception {
		System.out.println("json method called. " + json.toString());
		FeatureEvaluator fe = new FeatureEvaluator(json, data);
		return fe;
	}		

}

