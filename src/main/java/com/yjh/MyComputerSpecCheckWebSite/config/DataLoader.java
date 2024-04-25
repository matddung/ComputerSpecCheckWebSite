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
import java.util.List;

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
            List<CPU> existingCPUs = cpuRepository.findByName(data[0]);
            if (existingCPUs.isEmpty()) {
                CPU cpu = new CPU();
                cpu.setName(data[0]);
                cpu.setPrice(data[1]);
                cpu.setCoreCount(data[2]);
                cpu.setCoreClock(data[3]);
                cpu.setBoostClock(data[4]);
                cpu.setTDP(data[5]);
                cpu.setGraphics(data[6]);
                cpu.setSMT(data[7]);
                cpuRepository.save(cpu);
            }
        }
    }

    private void loadGPUData() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(new ClassPathResource("/data/GPU.csv").getInputStream()));
        String line;
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            List<GPU> existingGPUs = gpuRepository.findByName(data[0]);
            if (existingGPUs.isEmpty()) {
                GPU gpu = new GPU();
                gpu.setName(data[0]);
                gpu.setPrice(data[1]);
                gpu.setChipset(data[2]);
                gpu.setMemory(data[3]);
                gpu.setCoreClock(data[4]);
                gpu.setBoostClock(data[5]);
                gpu.setLength(data[6]);
                gpuRepository.save(gpu);
            }
        }
    }

    private void loadRAMData() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(new ClassPathResource("/data/RAM.csv").getInputStream()));
        String line;
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            List<RAM> existingRAMs = ramRepository.findByName(data[0]);
            if (existingRAMs.isEmpty()) {
                RAM ram = new RAM();
                ram.setName(data[0]);
                ram.setPrice(data[1]);
                ram.setSpeed(data[2]);
                ram.setModules(data[3]);
                ram.setPricePerGB(data[4]);
                ram.setFirstWordLatency(data[5]);
                ram.setCasLatency(data[6]);
                ramRepository.save(ram);
            }
        }
    }
}