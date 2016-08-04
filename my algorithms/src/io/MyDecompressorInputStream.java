package io;

import java.io.IOException;
import java.io.InputStream;

public class MyDecompressorInputStream extends InputStream {
	
	private InputStream in;
	private int num;
	private int counter;

	
	//c'tor
	public MyDecompressorInputStream(InputStream i) {
		
		this.setIn(i);
		this.counter=0;
		this.num=0;

	}
	
	@Override
	public int read() throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	public int read(int b) throws IOException {
		in.read();
		return -1;
	}
	
	@Override
	public int read(byte [] out) throws IOException {
		int index=0;
		num=in.read();
		counter=in.read();
		while(num!=-1 && counter!=-1)
		{
			for(int i = 0; i<counter; i++)
			{
				out[index] = (byte)num;
				index++;
				
			}
			num=in.read();
			counter=in.read();
		}
	    in.close();
	    return 0;
	}
	
	//get and set for the private data member
	public InputStream getIn() {
		return in;
	}
	public void setIn(InputStream in) {
		this.in = in;
	
	}
	
}
