package com.yjh.MyComputerSpecCheckWebSite.config;

import com.yjh.MyComputerSpecCheckWebSite.entity.computerParts.CPU;
import com.yjh.MyComputerSpecCheckWebSite.entity.computerParts.GPU;
import com.yjh.MyComputerSpecCheckWebSite.entity.computerParts.RAM;
import com.yjh.MyComputerSpecCheckWebSite.repository.CPURepository;
import com.yjh.MyComputerSpecCheckWebSite.repository.GPURepository;
import com.yjh.MyComputerSpecCheckWebSite.repository.RAMRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private CPURepository cpuRepository;

    @Autowired
    private GPURepository gpuRepository;

    @Autowired
    private RAMRepository ramRepository;

    @Override
    public void run(String... args) throws Exception {
        loadCPUData();
        loadGPUData();
        loadRAMData();
    }

    private void loadCPUData() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(new ClassPathResource("/data/CPU.csv").getInputStream()));
        String line;
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            CPU cpu = new CPU();
            cpu.setName(data[0]);
            try {
                cpu.setPrice(Double.parseDouble(data[1]));
            } catch (NumberFormatException e) {
                cpu.setPrice(null);
            }
            try {
                cpu.setCoreCount(Double.parseDouble(data[2]));
            } catch (NumberFormatException e) {
                cpu.setCoreCount(null);
            }
            try {
                cpu.setCoreClock(Double.parseDouble(data[3]));
            } catch (NumberFormatException e) {
                cpu.setCoreClock(null);
            }
            try {
                cpu.setBoostClock(Double.parseDouble(data[4]));
            } catch (NumberFormatException e) {
                cpu.setBoostClock(null);
            }
            try {
                cpu.setTDP(Double.parseDouble(data[5]));
            } catch (NumberFormatException e) {
                cpu.setTDP(null);
            }
            cpu.setGraphics(data[6]);
            cpu.setSMT(data[7]);
            cpuRepository.save(cpu);
        }
    }

    private void loadGPUData() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(new ClassPathResource("/data/GPU.csv").getInputStream()));
        String line;
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            GPU gpu = new GPU();
            gpu.setName(data[0]);
            try {
                gpu.setPrice(Double.parseDouble(data[1]));
            } catch (NumberFormatException e) {
                gpu.setPrice(null);
            }
            gpu.setChipset(data[2]);
            try {
                gpu.setMemory(Double.parseDouble(data[3]));
            } catch (NumberFormatException e) {
                gpu.setMemory(null);
            }
            try {
                gpu.setCoreClock(Double.parseDouble(data[4]));
            } catch (NumberFormatException e) {
                gpu.setCoreClock(null);
            }
            try {
                gpu.setBoostClock(Double.parseDouble(data[5]));
            } catch (NumberFormatException e) {
                gpu.setBoostClock(null);
            }
            try {
                gpu.setLength(Double.parseDouble(data[6]));
            } catch (NumberFormatException e) {
                gpu.setLength(null);
            }
            gpuRepository.save(gpu);
        }
    }

    private void loadRAMData() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(new ClassPathResource("/data/RAM.csv").getInputStream()));
        String line;
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            RAM ram = new RAM();
            ram.setName(data[0]);
            try {
                ram.setPrice(Double.parseDouble(data[1]));
            } catch (NumberFormatException e) {
                ram.setPrice(null);
            }
            try {
                ram.setSpeed(Double.parseDouble(data[2]));
            } catch (NumberFormatException e) {
                ram.setSpeed(null);
            }
            try {
                ram.setPricePerGB(Double.parseDouble(data[3]));
            } catch (NumberFormatException e) {
                ram.setPricePerGB(null);
            }
            try {
                ram.setFirstWordLatency(Double.parseDouble(data[4]));
            } catch (NumberFormatException e) {
                ram.setFirstWordLatency(null);
            }
            try {
                ram.setCasLatency(Double.parseDouble(data[5]));
            } catch (NumberFormatException e) {
                ram.setCasLatency(null);
            }
            ramRepository.save(ram);
        }
    }
}