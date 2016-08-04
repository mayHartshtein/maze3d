package io;

import java.io.IOException;
import java.io.OutputStream;

public class MyCompressorOutputStream extends OutputStream {
	
	private OutputStream out;
	private int counter;
	private int flag;
	
	
	//c'tor
	public MyCompressorOutputStream(OutputStream o) {
		
		this.setOut(o);
		this.counter=0;
		this.flag=0;
		
	}
	

	@Override
	public void write(int b) throws IOException {
		if (counter==0)
		{
			flag=b;
			counter++;
		}
		else if(flag==b)
		{
			counter++;
		}
		else
		{
			out.write(flag);
			out.write(counter);
			flag=b;
			counter=1;
		}
		

	}

	@Override
	public void write(byte[] bytes) throws IOException {
		
		for(int i=0;i<bytes.length;i++)
		{
			write(bytes[i]);
		}
		out.write(flag);
		out.write(counter);
		out.close();

	}
	
	//get and set for the private data member

	public OutputStream getOut() {
		return out;
	}

	public void setOut(OutputStream out) {
		this.out = out;
	}

}
