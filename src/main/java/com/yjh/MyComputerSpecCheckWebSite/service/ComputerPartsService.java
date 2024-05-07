package com.yjh.MyComputerSpecCheckWebSite.service;

import com.yjh.MyComputerSpecCheckWebSite.dto.computerParts.cpu.request.ComputerPartsCPURequest;
import com.yjh.MyComputerSpecCheckWebSite.dto.computerParts.cpu.response.ComputerPartsCPUResponse;
import com.yjh.MyComputerSpecCheckWebSite.dto.computerParts.gpu.request.ComputerPartsGPURequest;
import com.yjh.MyComputerSpecCheckWebSite.dto.computerParts.gpu.response.ComputerPartsGPUResponse;
import com.yjh.MyComputerSpecCheckWebSite.dto.computerParts.ram.requset.ComputerPartsRAMRequest;
import com.yjh.MyComputerSpecCheckWebSite.dto.computerParts.ram.response.ComputerPartsRAMResponse;
import com.yjh.MyComputerSpecCheckWebSite.repository.computerPartsRepository.CPURepository;
import com.yjh.MyComputerSpecCheckWebSite.repository.computerPartsRepository.GPURepository;
import com.yjh.MyComputerSpecCheckWebSite.repository.computerPartsRepository.RAMRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class ComputerPartsService {
    private final CPURepository cpuRepository;
    private final GPURepository gpuRepository;
    private final RAMRepository ramRepository;

    public ComputerPartsCPUResponse getSpecFromCPUName(ComputerPartsCPURequest request) {
        return cpuRepository.findByName(request.name())
                .map(ComputerPartsCPUResponse::from)
                .orElseThrow(() -> new NoSuchElementException("일치하는 CPU가 없습니다."));
    }

    public ComputerPartsGPUResponse getSpecFromGPUName(ComputerPartsGPURequest request) {
        return gpuRepository.findByName(request.name())
                .map(ComputerPartsGPUResponse::from)
                .orElseThrow(() -> new NoSuchElementException("일치하는 GPU가 없습니다."));
    }

    public ComputerPartsRAMResponse getSpecFromRAMName(ComputerPartsRAMRequest request) {
        return ramRepository.findByName(request.name())
                .map(ComputerPartsRAMResponse::from)
                .orElseThrow(() -> new NoSuchElementException("일치하는 RAM이 없습니다."));
    }
}
