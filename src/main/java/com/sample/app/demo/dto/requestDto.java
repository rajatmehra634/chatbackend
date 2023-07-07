package com.sample.app.demo.dto;
public class requestDto {

		private String model;
		private String prompt;
		private Integer max_tokens;
		private Integer temperature;
		private String top_p;
		private String stream;
		private String logprobs;
		
		public String getModel() {
			return model;
		}

		public void setModel(String model) {
			this.model = model;
		}
		
		public String getPrompt() {
			return prompt;
		}

		public void setPrompt(String prompt) {
			this.prompt = prompt;
		}

		public Integer getMax_tokens() {
			return max_tokens;
		}
		
		public void setMax_tokens(Integer max_tokens) {
			this.max_tokens = max_tokens;
		}
		
		public Integer getTemperature() {
			return temperature;
		}
		
		public void setTemperature(Integer temperature) {
			this.temperature = temperature;
		}
		
		public String getTop_p() {
			return top_p;
		}

		public void setTop_p(String top_p) {
			this.top_p = top_p;
		}

		public String getStream() {
			return stream;
		}

		public void setStream(String stream) {
			this.stream = stream;
		}
		
		public String getLogprobs() {
			return logprobs;
		}
		
		public void setLogprobs(String logprobs) {
			this.logprobs = logprobs;
		}

		@Override
		public String toString() {
			return "requestDto [model=" + model + ", prompt=" + prompt + ", max_tokens=" + max_tokens + ", temperature="
					+ temperature + ", top_p=" + top_p + ", stream=" + stream + ", logprobs=" + logprobs + "]";
		}
}